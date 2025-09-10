import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        boolean winner = false;
        boolean aiWinner = false;
        boolean full;
        int[][] grid = new int[3][3];

        initialiserMatrice(grid);
        afficherTableau(grid);
        do {
            tourJoueur(grid);
            winner = verifierSiGagner(grid);
            if (winner == false) {
                tourIA(grid);
                aiWinner = verifierSiIAGagner(grid);
            }
            afficherTableau(grid);
            full = verifierSiPlein(grid);
        }  while (winner == false && full == false && aiWinner == false);

        if ( winner == true) {
            System.out.println("\nVous avez gagné.");
        } else if (aiWinner == true) {
            System.out.println("\nL'IA a remporté la partie.");
        } else if (full == true) {
            System.out.println("\nÉgalité.");
        }

    }
        
    public static void afficherTableau(int[][] grid) {
        System.out.println("Coucou");
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
    
    public static void initialiserMatrice (int[][] grid) {
        
        int k = 1;
        
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                
                grid[j][i] = k;
                ++k;        
            }
        }
    }
    
    public static void tourJoueur (int[][] grid) {
        
        Scanner scanner = new Scanner(System.in);
        boolean valid;
        int caseX;
        
        do {
              System.out.printf("Sélectionnez une case (1-9): ");
              caseX = scanner.nextInt();
              
              if (caseX < 1 || caseX > 9) {
                  valid = false;
                  System.out.println("Valeur doit etre entre 1 et 9");
              } else {
                  valid = true;
              }
          } while (valid == false);
        
        switch (caseX) {
            case 1 : grid[0][0] = 0;break;
            case 2 : grid[0][1] = 0;break;
            case 3 : grid[0][2] = 0;break;
            case 4 : grid[1][0] = 0;break;
            case 5 : grid[1][1] = 0;break;
            case 6 : grid[1][2] = 0;break;
            case 7 : grid[2][0] = 0;break;
            case 8 : grid[2][1] = 0;break;
            case 9 : grid[2][2] = 0;break;
        }
    }
    
    public static void tourIA (int[][] grid) {
        
        Random randomGenerator = new Random();
        boolean valid;
        int caseO1;
        int caseO2;
        
        
        
        do {
            caseO1 = randomGenerator.nextInt(3);
            caseO2 = randomGenerator.nextInt(3);
            
            if (grid[caseO1][caseO2] == 0 || grid[caseO1][caseO2] == -1){
                valid = false;
            } else {
                grid[caseO1][caseO2] = -1;
                valid = true;
            }
        } while (valid == false);
        
    }
    
    public static boolean verifierSiPlein (int[][] grid)  {
        
        boolean full = false;
        int counter = 0;
        
        for (int j = 0; j < 3; ++j) {
                for (int i = 0; i < 3; ++i) {
                    if (grid[j][i] != 0 && grid[j][i] != -1) {
                        ++counter;
                    }
                }
            }
            if (counter <= 0) {
                full = true;
            }
           return full;
    }
    
    public static boolean verifierSiGagner (int[][] grid) {
        
        boolean winner = false;
        
        if (grid[0][0] == 0 && grid[0][1] == 0 && grid[0][2] == 0) {
            winner = true;
        } else if (grid[1][0] == 0 && grid[1][1] == 0 && grid[1][2] == 0) {
            winner = true;
        } else if (grid[2][0] == 0 && grid[2][1] == 0 && grid[2][2] == 0) {
            winner = true;
        } else if (grid[0][0] == 0 && grid[1][0] == 0 && grid[2][0] == 0) {
            winner = true;
        } else if (grid[0][1] == 0 && grid[1][1] == 0 && grid[2][1] == 0) {
            winner = true;
        } else if (grid[0][2] == 0 && grid[1][2] == 0 && grid[2][2] == 0) {
            winner = true;
        } else if (grid[0][0] == 0 && grid[1][1] == 0 && grid[2][2] == 0) {
            winner = true;
        } else if (grid[0][2] == 0 && grid[1][1] == 0 && grid[2][0] == 0) {
            winner = true;
        }
        
        return winner;
    }
    
    public static boolean verifierSiIAGagner(int[][] grid) {
        
        boolean aiWinner = false;
        
        if (grid[0][0] == -1 && grid[0][1] == -1 && grid[0][2] == -1) {
            aiWinner = true;
        } else if (grid[1][0] == -1 && grid[1][1] == -1 && grid[1][2] == -1) {
            aiWinner = true;
        } else if (grid[2][0] == -1 && grid[2][1] == -1 && grid[2][2] == -1) {
            aiWinner = true;
        } else if (grid[0][0] == -1 && grid[1][0] == -1 && grid[2][0] == -1) {
            aiWinner = true;
        } else if (grid[0][1] == -1 && grid[1][1] == -1 && grid[2][1] == -1) {
            aiWinner = true;
        } else if (grid[0][2] == -1 && grid[1][2] == -1 && grid[2][2] == -1) {
            aiWinner = true;
        } else if (grid[0][0] == -1 && grid[1][1] == -1 && grid[2][2] == -1) {
            aiWinner = true;
        } else if (grid[0][2] == -1 && grid[1][1] == -1 && grid[2][0] == -1) {
            aiWinner = true;
        }
        
        return aiWinner;
    }
    


    
}
