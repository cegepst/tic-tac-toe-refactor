public class Game {

    private final static int AI_TILE = -1;
    private final static int PLAYER_TILE = 0;

    private Grid grid;

    public Game() {
        this.grid = new Grid();
    }

    public void play() {
        boolean winner;
        boolean aiWinner = false;
        boolean full;

        this.grid.displayBoard();
        do {
            this.grid.playerTurn();
            winner = this.grid.checkWin(PLAYER_TILE);
            if (!winner) {
                this.grid.aiTurn();
                aiWinner = this.grid.checkWin(AI_TILE);
            }
            this.grid.displayBoard();
            full = this.grid.isFull();
        }  while (!winner && !full && !aiWinner);

        this.grid.displayWinner(winner, aiWinner, full);
    }
}
