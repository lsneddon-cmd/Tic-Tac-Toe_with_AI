package tictactoe;

public class HumanPlayer extends Player {
    private PlayerType playerType;
    private char symbol;
    private boolean turnTaken;

    HumanPlayer(PlayerType type) {
        super(type);
        this.turnTaken = false;
        this.symbol = 'X';
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public boolean isTurnTaken() {
        return turnTaken;
    }

    public void setTurnTaken(boolean turnTaken) {
        this.turnTaken = turnTaken;
    }

    public void takeTurn(int[] coords, Game game) {
        int row = Math.abs(coords[1] - game.getCells());
        int col = coords[0] - 1;
        if (game.getGameGrid()[row][col] == game.getEmpty()) {
            game.setGameGrid(this.symbol, row, col);
            this.turnTaken = true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            this.turnTaken = false;
        }
    }

}