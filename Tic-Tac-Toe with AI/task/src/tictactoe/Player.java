package tictactoe;

import static tictactoe.PlayerType.*;

public class Player {
    private PlayerType playerType;
    private char symbol;

    Player(PlayerType type) {
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

    public PlayerType getPlayerType() {
        return playerType;
    }

}
