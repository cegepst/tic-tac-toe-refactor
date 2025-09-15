import java.util.Random;

public class Ai {

    public final static int TILE = -1;

    public void turn(Grid grid) {
        Random randomGenerator = new Random();
        boolean valid;
        do {
            int row = randomGenerator.nextInt(3);
            int col = randomGenerator.nextInt(3);
            if (!grid.isTileEmpty(row, col)){
                valid = false;
            } else {
                grid.setTile(row, col, TILE);
                valid = true;
            }
        } while (!valid);
    }
}
