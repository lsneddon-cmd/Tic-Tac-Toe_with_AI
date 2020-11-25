package tictactoe;

import static tictactoe.PlayerType.CROSS;
import static tictactoe.PlayerType.NOUGHT;

public class HumanPlayer implements Player {
    private PlayerType playerType;
    private char symbol;

    HumanPlayer(PlayerType type) {
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
        int row = Math.abs(coords[1] - game.getCells());
        int col = coords[0] - 1;
        if (game.getGameGrid()[row][col] == game.getEmpty()) {
            game.setGameGrid(this.symbol, row, col);
            return true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

}