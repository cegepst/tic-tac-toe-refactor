
public class Grid {

    private int[][] grid = new int[3][3];

    public Grid() {
        initialize();
    }

    public void setTile(Position position, int character) {
        position.place(grid, character);
    }

    public boolean isTileEmpty(Position position) {
        return !(grid[position.getRow()][position.getCol()] == Player.TILE
                || grid[position.getRow()][position.getCol()] == Ai.TILE);
    }

    public void display() {
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
