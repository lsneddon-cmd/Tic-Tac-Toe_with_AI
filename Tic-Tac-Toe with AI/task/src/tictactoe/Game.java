package tictactoe;

import java.util.Arrays;

public class Game {
    private char[][] gameGrid;
    private int cells;
    private String gameState;
    private final char empty = ' ';
    private final char cross = 'X';
    private final char nought = 'O';

    Game (int cells) {
        this.cells = cells;
        this.gameState = "Game not finished";
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

    public char getCross() {
        return cross;
    }

    public char getNought() {
        return nought;
    }

    public void fillCells(String cellValuesAsString) {
        char[] cellValues = cellValuesAsString.toCharArray();
        for (int i = 0; i < this.cells; i++) {
            for (int j = 0; j < this.cells; j++) {
                if (cellValues[3 * i + j] == '_') {
                    gameGrid[i][j] = empty;
                } else {
                    gameGrid[i][j] = cellValues[3 * i + j];
                }
            }
        }
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

    public String getGameState() {
        return gameState;
    }

    public void updateGameState() {
        boolean conditionFound = false;
        while (!conditionFound) {
            // Horizontal and Vertical
            for (int i = 0; i < this.cells; i++) {
                if (this.gameGrid[i][0] == this.nought && this.gameGrid[i][1] == this.nought && this.gameGrid[i][2] == this.nought) {
                    this.gameState = "O wins";
                    conditionFound = true;
                } else if (this.gameGrid[0][i] == this.nought && this.gameGrid[1][i] == this.nought && this.gameGrid[2][i] == this.nought) {
                    this.gameState = "O wins";
                    conditionFound = true;
                }
            }
            for (int i = 0; i < this.cells; i++) {
                if (this.gameGrid[i][0] == this.cross && this.gameGrid[i][1] == this.cross && this.gameGrid[i][2] == this.cross) {
                    this.gameState = "X wins";
                    conditionFound = true;
                } else if (this.gameGrid[0][i] == this.cross && this.gameGrid[1][i] == this.cross && this.gameGrid[2][i] == this.cross) {
                    this.gameState = "X wins";
                    conditionFound = true;
                }
            }
            // Diagonals
            if (this.gameGrid[0][0] == this.nought && this.gameGrid[1][1] == this.nought && this.gameGrid[2][2] == this.nought) {
                this.gameState = "O wins";
                conditionFound = true;
            } else if (this.gameGrid[0][2] == this.nought && this.gameGrid[1][1] == this.nought && this.gameGrid[2][0] == this.nought) {
                this.gameState = "O wins";
                conditionFound = true;
            }
            if (this.gameGrid[0][0] == this.cross && this.gameGrid[1][1] == this.cross && this.gameGrid[2][2] == this.cross) {
                this.gameState = "X wins";
                conditionFound = true;
            } else if (this.gameGrid[0][2] == this.cross && this.gameGrid[1][1] == this.cross && this.gameGrid[2][0] == this.cross) {
                this.gameState = "X wins";
                conditionFound = true;
            }
            // Not won
            conditionFound = true;
            if (!isSpace()) {
                this.gameState = "Draw";
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

    public boolean isXTurn() {
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < this.cells; i++) {
            for (int j = 0; j < this.cells; j++) {
                if (gameGrid[i][j] == nought) {
                    oCount++;
                } else if (gameGrid[i][j] == cross) {
                    xCount++;
                }
            }
        }
        return xCount <= oCount;
    }

}
