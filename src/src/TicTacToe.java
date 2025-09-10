import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static int[][] grid = new int[3][3];
    final static int AI_TILE = -1;
    final static int PLAYER_TILE = 0;

    public static void main(String[] args) {

        boolean winner;
        boolean aiWinner = false;
        boolean full;


        initialiserMatrice();
        afficherTableau();
        do {
            tourJoueur();
            winner = verifierSiGagner(PLAYER_TILE);
            if (!winner) {
                tourIA();
                aiWinner = verifierSiGagner(AI_TILE);
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
                
                grid[j][i] = k;
                ++k;        
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
            
            if (grid[caseO1][caseO2] == PLAYER_TILE || grid[caseO1][caseO2] == AI_TILE){
                valid = false;
            } else {
                grid[caseO1][caseO2] = AI_TILE;
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
    
    public static boolean verifierSiGagner(int joueur) {

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





}
