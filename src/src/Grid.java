import java.util.Random;

public class Grid {

    private static final int[][] GRID = new int[3][3];
    private final static int AI_TILE = -1;
    private final static int PLAYER_TILE = 0;

    public void displayWinner(boolean winner, boolean aiWinner, boolean full) {
        if (winner) {
            Console.print("Vous avez gagné.");
        } else if (aiWinner) {
            Console.print("\nL'IA a remporté la partie.");
        } else if (full) {
            Console.print("\nÉgalité.");
        }
    }

    public void displayBoard() {
        System.out.print("\n");
        
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
               
                if (GRID[j][i] == 0 && i == 2) {
                    System.out.print(" X\n");
                } else if (GRID[j][i] == 0 && i != 2) {
                    System.out.print(" X |");
                } else if (GRID[j][i] == -1 && i == 2) {
                    System.out.print(" O\n");
                } else if (GRID[j][i] == -1 && i != 2) {
                    System.out.print(" O |");
                } else if (i == 2){
                    System.out.printf(" %d\n", GRID[j][i]);
                } else {              
                    System.out.printf(" %d |", GRID[j][i]);
                } 
            }
        }
    }

    public void initializeGrid() {
        int k = 1;
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                GRID[j][i] = k++;
            }
        }
    }

    public void playerTurn() {
        boolean valid;
        int input;
        
        do {
              Console.print("Sélectionnez une case (1-9): ");
              input = Console.readInt();
              
              if (input < 1 || input > 9) {
                  valid = false;
                  Console.print("Valeur doit etre entre 1 et 9");
              } else {
                  valid = true;
              }
          } while (!valid);

        GRID[((input - 1) / 3)][(input - 1) % 3] = PLAYER_TILE;
    }

    public void aiTurn() {
        
        Random randomGenerator = new Random();
        boolean valid;

        int caseO1;
        int caseO2;
        
        do {
            caseO1 = randomGenerator.nextInt(3);
            caseO2 = randomGenerator.nextInt(3);
            
            if (GRID[caseO1][caseO2] == PLAYER_TILE || GRID[caseO1][caseO2] == AI_TILE){
                valid = false;
            } else {
                GRID[caseO1][caseO2] = AI_TILE;
                valid = true;
            }
        } while (valid == false);
    }

    public boolean isFull()  {

        int counter = 0;
        
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                if (GRID[j][i] != 0 && GRID[j][i] != -1) {
                    ++counter;
                }
            }
        }
        return counter <= 0;
    }

    public boolean checkWin(int joueur) {

        if ((GRID[0][0] == joueur && GRID[0][1] == joueur && GRID[0][2] == joueur) ||
                (GRID[1][0] == joueur && GRID[1][1] == joueur && GRID[1][2] == joueur) ||
                (GRID[2][0] == joueur && GRID[2][1] == joueur && GRID[2][2] == joueur) ||

                (GRID[0][0] == joueur && GRID[1][0] == joueur && GRID[2][0] == joueur) ||
                (GRID[0][1] == joueur && GRID[1][1] == joueur && GRID[2][1] == joueur) ||
                (GRID[0][2] == joueur && GRID[1][2] == joueur && GRID[2][2] == joueur) ||

                (GRID[0][0] == joueur && GRID[1][1] == joueur && GRID[2][2] == joueur) ||
                (GRID[0][2] == joueur && GRID[1][1] == joueur && GRID[2][0] == joueur)) {
            return true;
        }
        return false;
    }
}
