public class Game {

    private final static int AI_TILE = -1;

    private Grid grid;
    private Player player;
    private Ai ai;
    private GameStatus gameStatus;

    public Game() {
        grid = new Grid();
        player = new Player();
        ai = new Ai();
        gameStatus = new GameStatus();
    }

    public void play() {
        do {
            grid.display();
            player.turn(grid);
            gameStatus.setWinner(grid.checkWin(Player.TILE));
            if (!gameStatus.isWinner()) {
                ai.turn(grid);
                gameStatus.setAiWinner(grid.checkWin(AI_TILE));
            }
            gameStatus.setFull(grid.isFull());
        }  while (!gameStatus.hasGameEnded());
        grid.display();
        gameStatus.displayWinner();
    }
}
