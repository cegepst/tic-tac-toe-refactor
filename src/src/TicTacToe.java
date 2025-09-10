import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static int[][] grid = new int[3][3];

    public static void main(String[] args) {

        boolean winner;
        boolean aiWinner = false;
        boolean full;


        initialiserMatrice();
        afficherTableau();
        do {
            tourJoueur();
            winner = verifierSiGagner();
            if (!winner) {
                tourIA();
                aiWinner = verifierSiIAGagner();
            }
            afficherTableau();
            full = verifierSiPlein();
        }  while (!winner && !full && !aiWinner);

        if ( winner) {
            Console.print("Vous avez gagné.");
        } else if (aiWinner) {
            Console.print("\nL'IA a remporté la partie.");
        } else if (full) {
            Console.print("\nÉgalité.");
        }

    }

    public static void afficherTableau() {
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

    public static void initialiserMatrice () {
        int k = 1;
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                grid[j][i] = k++;
            }
        }
    }

    public static void tourJoueur () {

        Scanner scanner = new Scanner(System.in);
        boolean valid;
        int caseX;

        do {
              System.out.printf("Sélectionnez une case (1-9): ");
              caseX = scanner.nextInt();

              if (caseX < 1 || caseX > 9) {
                  valid = false;
                  Console.print("Valeur doit etre entre 1 et 9");
              } else {
                  valid = true;
              }
          } while (!valid);

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

    public static void tourIA () {

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
    
    public static boolean verifierSiPlein ()  {
        
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

    public static boolean verifierSiGagner () {
        
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
    
    public static boolean verifierSiIAGagner() {
        
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
