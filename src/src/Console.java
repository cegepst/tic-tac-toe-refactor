import java.util.Scanner;

public class Console {

    public static void print(String message) {
        System.out.println(message);
    }

    public static Integer readInt() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Choix invalide. Veuillez entrer un nombre.");
            return null;
        }
    }
}
