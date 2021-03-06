package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Input command: ");
                input = scanner.nextLine();
                InputHandler inputs = new InputHandler(input);
                flag = true;
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
