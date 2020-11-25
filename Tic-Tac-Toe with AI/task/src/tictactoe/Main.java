package tictactoe;

public class Main {
    public static void main(String[] args) {
        GameLoop loop = new GameLoop(new Game(3),
                new HumanPlayer(PlayerType.CROSS),
                new AIPlayer(PlayerType.NOUGHT));
        loop.Run();
    }
}
