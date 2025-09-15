public class GameStatus {

    private boolean playerWon;
    private boolean aiWon;
    private boolean tie;

    public boolean hasGameEnded() {
        return playerWon || tie || aiWon;
    }

    public void displayWinner() {
        if (playerWon) {
            Console.print("Vous avez gagné.");
        } else if (aiWon) {
            Console.print("\nL'IA a remporté la partie.");
        } else if (tie) {
            Console.print("\nÉgalité.");
        }
    }

    public boolean hasPlayerWon() {
        return playerWon;
    }

    public boolean hasAiWon() {
        return aiWon;
    }

    public boolean isTie() {
        return tie;
    }

    public void setPlayerWon(boolean playerWon) {
        this.playerWon = playerWon;
    }

    public void setAiWon(boolean aiWon) {
        this.aiWon = aiWon;
    }

    public void setTie(boolean tie) {
        this.tie = tie;
    }
}
