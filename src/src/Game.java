public class Game {

    private final static int AI_TILE = -1;

    private Grid grid;
    private Player player;
    private Ai ai;

    public Game() {
        grid = new Grid();
        player = new Player();
        ai = new Ai();
    }

    public void play() {
        boolean winner;
        boolean aiWinner = false;
        boolean full;

        this.grid.displayBoard();
        do {
            player.turn(grid);
            winner = this.grid.checkWin(Player.TILE);
            if (!winner) {
                ai.turn(grid);
                aiWinner = this.grid.checkWin(AI_TILE);
            }
            this.grid.displayBoard();
            full = this.grid.isFull();
        }  while (!winner && !full && !aiWinner);

        this.grid.displayWinner(winner, aiWinner, full);
    }
}
