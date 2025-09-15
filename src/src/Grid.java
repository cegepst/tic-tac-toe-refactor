import java.util.Random;

public class Grid {

    private final static int AI_TILE = -1;

    private int[][] grid = new int[3][3];

    public Grid() {
        initialize();
    }

    public void displayWinner(boolean winner, boolean aiWinner, boolean full) {
        if (winner) {
            Console.print("Vous avez gagné.");
        } else if (aiWinner) {
            Console.print("\nL'IA a remporté la partie.");
        } else if (full) {
            Console.print("\nÉgalité.");
        }
    }

    public void setTile(int row, int col, int character) {
        grid[row][col] = character;
    }

    public void displayBoard() {
        System.out.print("\n");
        
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
               
                if (grid[j][i] == 0 && i == 2) {
                    System.out.print(" X\n");
                } else if (grid[j][i] == 0 && i != 2) {
                    System.out.print(" X |");
                } else if (grid[j][i] == -1 && i == 2) {
                    System.out.print(" O\n");
                } else if (grid[j][i] == -1 && i != 2) {
                    System.out.print(" O |");
                } else if (i == 2){
                    System.out.printf(" %d\n", grid[j][i]);
                } else {              
                    System.out.printf(" %d |", grid[j][i]);
                } 
            }
        }
    }

    public void aiTurn() {
        Random randomGenerator = new Random();
        boolean valid;

        int caseO1;
        int caseO2;
        
        do {
            caseO1 = randomGenerator.nextInt(3);
            caseO2 = randomGenerator.nextInt(3);
            
            if (grid[caseO1][caseO2] == Player.TILE || grid[caseO1][caseO2] == AI_TILE){
                valid = false;
            } else {
                grid[caseO1][caseO2] = AI_TILE;
                valid = true;
            }
        } while (valid == false);
    }

    public boolean isFull()  {

        int counter = 0;
        
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                if (grid[j][i] != 0 && grid[j][i] != -1) {
                    ++counter;
                }
            }
        }
        return counter <= 0;
    }

    public boolean checkWin(int joueur) {

        if ((grid[0][0] == joueur && grid[0][1] == joueur && grid[0][2] == joueur) ||
                (grid[1][0] == joueur && grid[1][1] == joueur && grid[1][2] == joueur) ||
                (grid[2][0] == joueur && grid[2][1] == joueur && grid[2][2] == joueur) ||

                (grid[0][0] == joueur && grid[1][0] == joueur && grid[2][0] == joueur) ||
                (grid[0][1] == joueur && grid[1][1] == joueur && grid[2][1] == joueur) ||
                (grid[0][2] == joueur && grid[1][2] == joueur && grid[2][2] == joueur) ||

                (grid[0][0] == joueur && grid[1][1] == joueur && grid[2][2] == joueur) ||
                (grid[0][2] == joueur && grid[1][1] == joueur && grid[2][0] == joueur)) {
            return true;
        }
        return false;
    }

    private void initialize() {
        int k = 1;
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                grid[j][i] = k++;
            }
        }
    }
}
