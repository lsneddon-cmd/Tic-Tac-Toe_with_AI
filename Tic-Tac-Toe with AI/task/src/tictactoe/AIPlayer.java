package tictactoe;

import static tictactoe.PlayerType.CROSS;
import static tictactoe.PlayerType.NOUGHT;

public class AIPlayer implements Player {
    private PlayerType playerType;
    private char symbol;

    AIPlayer(PlayerType type) {
        switch (type) {
            case NOUGHT:
                this.playerType = NOUGHT;
                this.symbol = 'O';
                break;
            case CROSS:
                this.playerType = CROSS;
                this.symbol = 'X';
                break;
            default:
                throw new Error("Player not initialised correctly");
        }
    }

    @Override
    public boolean takeTurn(int[] coords, Game game) {
        int i = coords[0];
        int j = coords[1];
        boolean updated = false;
        while (!updated) {
            i = (int) Math.floor(Math.random() * 3);
            j = (int) Math.floor(Math.random() * 3);
            if (game.getGameGrid()[i][j] == game.getEmpty()) {
                game.setGameGrid(this.symbol, i, j);
                updated = true;
            }
        }
        return true;
    }
}
