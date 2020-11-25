package tictactoe;

public class AIPlayer extends Player {
    private PlayerType playerType;
    private char symbol;

    AIPlayer(PlayerType type) {
        super(type);
        this.symbol = 'O';
    }

    public void takeAITurn(Game game) {
        int i = 0;
        int j = 0;
        boolean updated = false;
        while (!updated) {
            i = (int) Math.floor(Math.random() * 3);
            j = (int) Math.floor(Math.random() * 3);
            if (game.getGameGrid()[i][j] == game.getEmpty()) {
                game.setGameGrid(this.symbol, i, j);
                updated = true;
            }
        }
    }
}
