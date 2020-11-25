package tictactoe;

public class InputHandler {
    private boolean start;
    private Player playerOne;
    private Player playerTwo;

    public InputHandler(String input) throws Exception {
        if (input.equals("exit")) {
            System.exit(0);
        } else {
            start = true;
            String[] commands = input.split(" ");

            if (commands.length != 3 || !commands[0].equals("start")) {
                throw new Exception("Bad parameters!");
            }

            if (commands[1].equals("user")) {
                playerOne = new HumanPlayer(PlayerType.CROSS);
            } else if (commands[1].equals("easy")) {
                playerOne = new AIPlayer(PlayerType.CROSS);
            } else {
                throw new Exception("Bad parameters!");
            }

            if (commands[2].equals("user")) {
                playerTwo = new HumanPlayer(PlayerType.NOUGHT);
            } else if (commands[2].equals("easy")) {
                playerTwo = new AIPlayer(PlayerType.NOUGHT);
            } else {
                throw new Exception("Bad parameters!");
            }
        }
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public boolean isStart() {
        return start;
    }
}
