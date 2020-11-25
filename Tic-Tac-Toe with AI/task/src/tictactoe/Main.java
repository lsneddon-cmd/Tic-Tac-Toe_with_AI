package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            try {
                System.out.print("Input command: ");
                input = scanner.nextLine();
                InputHandler inputs = new InputHandler(input);
                GameLoop loop = new GameLoop(new Game(3),
                        inputs.getPlayerOne(),
                        inputs.getPlayerTwo());
                loop.Run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
