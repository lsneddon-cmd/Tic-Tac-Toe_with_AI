package tictactoe;

import java.util.Scanner;

public class GameLoop {
    private Game game;
    private Player playerOne;
    private Player playerTwo;
    boolean xTurn;
    boolean oTurn;

    public GameLoop(Game game, Player one, Player two) {
        this.game = game;
        this.playerOne = one;
        this.playerTwo = two;
        xTurn = true;
        oTurn = false;
    }

    public void Run() {
        while(game.getGameState() == GameState.UNFINISHED) {
            if (xTurn) {
                while (!oTurn) {
                    oTurn = playerOne.takeTurn(getCoOrdinates(), game);
                    xTurn = !oTurn;
                }
            } else {
                System.out.println("Making move level \"easy\"");
                xTurn = playerTwo.takeTurn(new int[] {0, 0}, game);
                oTurn = !xTurn;
            }
            game.printGame();
            game.updateGameState();
        }
        switch (game.getGameState()) {
            case DRAW:
                System.out.println("Draw");
                break;
            case X_WINS:
                System.out.println("X Wins");
                break;
            case O_WINS:
                System.out.println("O Wins");
                break;
            default:
                System.out.println("Unable to establish game state");
        }
    }

    public static int[] getCoOrdinates() {
        Scanner sc = new Scanner(System.in);
        boolean correctInput = false;
        String input = "";
        int[] coords = new int[2];
        while (!correctInput) {
            System.out.println("Enter the coordinates: ");
            input = sc.nextLine();
            if (input.matches("[1-3]\\s[1-3]")) {
                String[] coordsAsString = input.split(" ");
                coords[0] = Integer.parseInt(coordsAsString[0]);
                coords[1] = Integer.parseInt(coordsAsString[1]);
                correctInput = true;
            } else if (input.matches("[0-9]\\s[0-9]")) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        return coords;
    }
}
