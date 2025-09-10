import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        boolean winner = false;
        boolean aiWinner = false;
        boolean full;
        int[][] intArray = new int[3][3];

        initialiserMatrice(intArray);
        afficherTableau(intArray);
        do {
            tourJoueur(intArray);
            winner = verifierSiGagner(intArray);
            if (winner == false) {
                tourIA(intArray);
                aiWinner = verifierSiIAGagner(intArray);
            }
            afficherTableau(intArray);
            full = verifierSiPlein(intArray);
        }  while (winner == false && full == false && aiWinner == false);

        if ( winner == true) {
            System.out.println("\nVous avez gagné.");
        } else if (aiWinner == true) {
            System.out.println("\nL'IA a remporté la partie.");
        } else if (full == true) {
            System.out.println("\nÉgalité.");
        }

    }
        
    public static void afficherTableau(int[][] intArray) {
        System.out.println("Coucou");
        System.out.print("\n");
        
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
               
                if (intArray[j][i] == 0 && i == 2) {
                    System.out.print(" X\n");
                } else if (intArray[j][i] == 0 && i != 2) {
                    System.out.print(" X |");
                } else if (intArray[j][i] == -1 && i == 2) {
                    System.out.print(" O\n");
                } else if (intArray[j][i] == -1 && i != 2) {
                    System.out.print(" O |");
                } else if (i == 2){
                    System.out.printf(" %d\n", intArray[j][i]);
                } else {              
                    System.out.printf(" %d |", intArray[j][i]);
                } 
            }
        }
    }
    
    public static void initialiserMatrice (int[][] intArray) {
        
        int k = 1;
        
        for (int j = 0; j < 3; ++j) {
            for (int i = 0; i < 3; ++i) {
                
                intArray[j][i] = k;
                ++k;        
            }
        }
    }
    
    public static void tourJoueur (int[][] intArray) {
        
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
            case 1 : intArray[0][0] = 0;break;
            case 2 : intArray[0][1] = 0;break;
            case 3 : intArray[0][2] = 0;break;
            case 4 : intArray[1][0] = 0;break;
            case 5 : intArray[1][1] = 0;break;
            case 6 : intArray[1][2] = 0;break;
            case 7 : intArray[2][0] = 0;break;
            case 8 : intArray[2][1] = 0;break;
            case 9 : intArray[2][2] = 0;break;
        }
    }
    
    public static void tourIA (int[][] intArray) {
        
        Random randomGenerator = new Random();
        boolean valid;
        int caseO1;
        int caseO2;
        
        
        
        do {
            caseO1 = randomGenerator.nextInt(3);
            caseO2 = randomGenerator.nextInt(3);
            
            if (intArray[caseO1][caseO2] == 0 || intArray[caseO1][caseO2] == -1){
                valid = false;
            } else {
                intArray[caseO1][caseO2] = -1;
                valid = true;
            }
        } while (valid == false);
        
    }
    
    public static boolean verifierSiPlein (int[][] intArray)  {
        
        boolean full = false;
        int counter = 0;
        
        for (int j = 0; j < 3; ++j) {
                for (int i = 0; i < 3; ++i) {
                    if (intArray[j][i] != 0 && intArray[j][i] != -1) {
                        ++counter;
                    }
                }
            }
            if (counter <= 0) {
                full = true;
            }
           return full;
    }
    
    public static boolean verifierSiGagner (int[][] intArray) {
        
        boolean winner = false;
        
        if (intArray[0][0] == 0 && intArray[0][1] == 0 && intArray[0][2] == 0) {
            winner = true;
        } else if (intArray[1][0] == 0 && intArray[1][1] == 0 && intArray[1][2] == 0) {
            winner = true;
        } else if (intArray[2][0] == 0 && intArray[2][1] == 0 && intArray[2][2] == 0) {
            winner = true;
        } else if (intArray[0][0] == 0 && intArray[1][0] == 0 && intArray[2][0] == 0) {
            winner = true;
        } else if (intArray[0][1] == 0 && intArray[1][1] == 0 && intArray[2][1] == 0) {
            winner = true;
        } else if (intArray[0][2] == 0 && intArray[1][2] == 0 && intArray[2][2] == 0) {
            winner = true;
        } else if (intArray[0][0] == 0 && intArray[1][1] == 0 && intArray[2][2] == 0) {
            winner = true;
        } else if (intArray[0][2] == 0 && intArray[1][1] == 0 && intArray[2][0] == 0) {
            winner = true;
        }
        
        return winner;
    }
    
    public static boolean verifierSiIAGagner(int[][] intArray) {
        
        boolean aiWinner = false;
        
        if (intArray[0][0] == -1 && intArray[0][1] == -1 && intArray[0][2] == -1) {
            aiWinner = true;
        } else if (intArray[1][0] == -1 && intArray[1][1] == -1 && intArray[1][2] == -1) {
            aiWinner = true;
        } else if (intArray[2][0] == -1 && intArray[2][1] == -1 && intArray[2][2] == -1) {
            aiWinner = true;
        } else if (intArray[0][0] == -1 && intArray[1][0] == -1 && intArray[2][0] == -1) {
            aiWinner = true;
        } else if (intArray[0][1] == -1 && intArray[1][1] == -1 && intArray[2][1] == -1) {
            aiWinner = true;
        } else if (intArray[0][2] == -1 && intArray[1][2] == -1 && intArray[2][2] == -1) {
            aiWinner = true;
        } else if (intArray[0][0] == -1 && intArray[1][1] == -1 && intArray[2][2] == -1) {
            aiWinner = true;
        } else if (intArray[0][2] == -1 && intArray[1][1] == -1 && intArray[2][0] == -1) {
            aiWinner = true;
        }
        
        return aiWinner;
    }
    


    
}
