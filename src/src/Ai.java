public class Ai {

    public final static int TILE = -1;

    public void turn(Grid grid) {
        boolean valid;
        do {
            Position position = new Position();
            if (!grid.isTileEmpty(position)){
                valid = false;
            } else {
                grid.setTile(position, TILE);
                valid = true;
            }
        } while (!valid);
    }
}
