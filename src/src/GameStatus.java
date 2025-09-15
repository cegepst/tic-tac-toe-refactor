public class GameStatus {

    private boolean winner;
    private boolean aiWinner;
    private boolean full;

    public boolean hasGameEnded() {
        return winner || full || aiWinner;
    }

    public void displayWinner() {
        if (winner) {
            Console.print("Vous avez gagné.");
        } else if (aiWinner) {
            Console.print("\nL'IA a remporté la partie.");
        } else if (full) {
            Console.print("\nÉgalité.");
        }
    }

    public boolean isWinner() {
        return winner;
    }

    public boolean isAiWinner() {
        return aiWinner;
    }

    public boolean isFull() {
        return full;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public void setAiWinner(boolean aiWinner) {
        this.aiWinner = aiWinner;
    }

    public void setFull(boolean full) {
        this.full = full;
    }
}
