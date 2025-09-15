import java.util.Random;

public class Position {

    private int row;
    private int col;

    public Position() {
        Random randomGenerator = new Random();
        row = randomGenerator.nextInt(3);
        col = randomGenerator.nextInt(3);
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void place(int[][] grid, int character) {
        grid[row][col] = character;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
