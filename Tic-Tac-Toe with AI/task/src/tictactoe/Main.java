package tictactoe;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // write your code here
        Game game = new Game(3);

        HumanPlayer x = new HumanPlayer(PlayerType.CROSS);
        AIPlayer o = new AIPlayer(PlayerType.NOUGHT);


        game.fillCells("         ");
        game.printGame();

        while(game.getGameState().equals("Game not finished")) {

            if (game.isXTurn()) {
                while (!x.isTurnTaken()) {
                    x.takeTurn(getCoOrdinates(), game);
                }
                x.setTurnTaken(false);
                } else {
                System.out.println("Making move level \"easy\"");
                o.takeAITurn(game);
            }
            game.printGame();
            game.updateGameState();
        }
        System.out.println(game.getGameState());
    }

    public static int[] getCoOrdinates() {
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
