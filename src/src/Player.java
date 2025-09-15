public class Player {

    public final static int TILE = 0;

    public void turn(Grid grid) {
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
        grid.setTile(new Position((input - 1) / 3, (input - 1) % 3), TILE);
    }
}
