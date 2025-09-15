public class Game {

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
            playRound();
        }  while (!gameStatus.hasGameEnded());
        grid.display();
        gameStatus.displayWinner();
    }

    private void playRound() {
        grid.display();
        player.turn(grid);
        gameStatus.setPlayerWon(grid.checkWin(Player.TILE));
        if (!gameStatus.hasPlayerWon()) {
            ai.turn(grid);
            gameStatus.setAiWon(grid.checkWin(Ai.TILE));
        }
        gameStatus.setTie(grid.isFull());
    }
}
