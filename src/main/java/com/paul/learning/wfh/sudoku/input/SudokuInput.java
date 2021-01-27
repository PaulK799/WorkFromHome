package com.paul.learning.wfh.sudoku.input;

import java.util.Arrays;

import static com.paul.learning.wfh.constants.GlobalConstants.STRING_NEW_LINE;

/**
 * A POJO class representing the
 */
public class SudokuInput {
    private int[][] board;

    public int[][] getBoard() {
        return board;
    }
    public void setBoard(int[][] image) {
        this.board = image;
    }

    /**
     * Defines a method for outputting the image
     *
     * @return The formatted {@link int[][]} array.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(STRING_NEW_LINE);
        int[][] boardToOutput = getBoard();
        for (int[] row : boardToOutput) {
            stringBuilder.append(Arrays.toString(row));
            stringBuilder.append(STRING_NEW_LINE);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
