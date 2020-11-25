package tictactoe;

import java.util.Arrays;

public class Game {
    private char[][] gameGrid;
    private int cells;
    private GameState gameState;
    private final char empty = ' ';
    private final char cross = 'X';
    private final char nought = 'O';

    Game (int cells) {
        this.cells = cells;
        this.gameState = GameState.UNFINISHED;
        this.gameGrid = new char[this.cells][this.cells];
        for (int i = 0; i < this.cells; i++) {
            Arrays.fill(this.gameGrid[i], this.empty);
        }
    }

    public char[][] getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(char symbol, int row, int col) {
        this.gameGrid[row][col] = symbol;
    }

    public int getCells() {
        return cells;
    }

    public char getEmpty() {
        return empty;
    }

    public void printGame() {
        System.out.print(" ");
        for (int i = 0; i < this.cells * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < this.cells; i++) {
            System.out.print("|");
            for (int j = 0; j < this.cells; j++) {
                System.out.print(" " + this.gameGrid[i][j]);
            }

            System.out.println(" |");
        }
        System.out.print(" ");
        for (int i = 0; i < this.cells * 2 + 1; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void updateGameState() {
        boolean conditionFound = false;
        while (!conditionFound) {
            // Horizontal and Vertical
            for (int i = 0; i < this.cells; i++) {
                if (this.gameGrid[i][0] == this.nought && this.gameGrid[i][1] == this.nought && this.gameGrid[i][2] == this.nought) {
                    this.gameState = GameState.O_WINS;
                    conditionFound = true;
                    return;
                } else if (this.gameGrid[0][i] == this.nought && this.gameGrid[1][i] == this.nought && this.gameGrid[2][i] == this.nought) {
                    this.gameState = GameState.O_WINS;
                    conditionFound = true;
                    return;
                }
            }
            for (int i = 0; i < this.cells; i++) {
                if (this.gameGrid[i][0] == this.cross && this.gameGrid[i][1] == this.cross && this.gameGrid[i][2] == this.cross) {
                    this.gameState = GameState.X_WINS;
                    conditionFound = true;
                    return;
                } else if (this.gameGrid[0][i] == this.cross && this.gameGrid[1][i] == this.cross && this.gameGrid[2][i] == this.cross) {
                    this.gameState = GameState.X_WINS;
                    conditionFound = true;
                    return;
                }
            }
            // Diagonals
            if (this.gameGrid[0][0] == this.nought && this.gameGrid[1][1] == this.nought && this.gameGrid[2][2] == this.nought) {
                this.gameState = GameState.O_WINS;
                conditionFound = true;
                return;
            } else if (this.gameGrid[0][2] == this.nought && this.gameGrid[1][1] == this.nought && this.gameGrid[2][0] == this.nought) {
                this.gameState = GameState.O_WINS;
                conditionFound = true;
                return;
            }
            if (this.gameGrid[0][0] == this.cross && this.gameGrid[1][1] == this.cross && this.gameGrid[2][2] == this.cross) {
                this.gameState = GameState.X_WINS;
                conditionFound = true;
                return;
            } else if (this.gameGrid[0][2] == this.cross && this.gameGrid[1][1] == this.cross && this.gameGrid[2][0] == this.cross) {
                this.gameState = GameState.X_WINS;
                conditionFound = true;
                return;
            }
            // Not won
            conditionFound = true;
            if (!isSpace()) {
                this.gameState = GameState.DRAW;
            }
        }
    }

    public boolean isSpace() {
        boolean spaceLeft = false;
        for (int i = 0; i < this.cells; i++) {
            for (int j = 0; j < this.cells; j++) {
                if (this.gameGrid[i][j] == empty) {
                    spaceLeft = true;
                    break;
                }
            }
        }
        return spaceLeft;
    }
}
