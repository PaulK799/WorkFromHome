package com.paul.learning.wfh.puzzles.sudoku.services;

import com.paul.learning.wfh.puzzles.sudoku.input.SudokuInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

/**
 * A Service which performs a Sudoku Solver Algorithm.
 *
 * <p>
 * Constraints:
 * Row-Column: Each intersection of a row and column, i.e, each cell, must contain exactly one number.
 * Row-Number: Each row must contain each number exactly once
 * Column-Number: Each column must contain each number exactly once.
 * Box-Number: Each box must contain each number exactly once.
 * </p>
 */
@Service
public class SudokuService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SudokuService.class);
    private static final int UNMAPPED_VALUE = 0;
    private static final int SUDOKU_MIN_VALUE = 1;
    private static final int SUDOKU_MAX_VALUE = 9;

    /**
     * Solves the provided {@link SudokuInput}.
     *
     * @param sodokuInput - The {@link SudokuInput} to be processed.
     * @return The {@link SudokuInput} solved.
     */
    public SudokuInput solve(SudokuInput sodokuInput) {
        int[][] board = sodokuInput.getBoard();
        int maxColumnLength = board[0].length;
        int maxRowLength = board.length;

        LOGGER.info("Starting to solve Sudoku board.");
        solve(board, maxRowLength, maxColumnLength);
        if (!solve(board, maxRowLength, maxColumnLength)) {
            throw new IllegalArgumentException("Unsolvable board.");
        }
        return sodokuInput;
    }

    /**
     * Solves the Sudoku board provided.
     *
     * @param board           - The Sudoku board to be solved.
     * @param maxRowLength    - The max length of the row to be processed.
     * @param maxColumnLength - The max length of the column to be processed.
     * @return A boolean indicating if the board has been solved.
     */
    private boolean solve(int[][] board, int maxRowLength, int maxColumnLength) {
        for (int row = 0; row < maxRowLength; row++) {
            for (int column = 0; column < maxColumnLength; column++) {
                if (board[row][column] == UNMAPPED_VALUE) {
                    for (int numberValue = SUDOKU_MIN_VALUE; numberValue <= SUDOKU_MAX_VALUE; numberValue++) {
                        //Temporarily set board value.
                        board[row][column] = numberValue;
                        // Check Constraints & Recursively iterate through selected path.
                        // 1. Row does not contain value.
                        // 2. Column does not contain value.
                        // 3. Grid does not contain value.
                        if (checkConstraintRow(board, maxRowLength, row)
                                && checkConstraintColumn(board, maxColumnLength, column)
                                && checkConstraintGrid(board, maxColumnLength, row, column)
                                && solve(board, maxRowLength, maxColumnLength)) {
                            return true;
                        }
                        // Backtrack value to unmapped.
                        board[row][column] = UNMAPPED_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validate if the current row is in a valid state.
     *
     * @param board           - The board being processed.
     * @param maxColumnLength - The max column length.
     * @param row             - The row being validated.
     * @return A boolean indicating if the row is valid.
     */
    private boolean checkConstraintRow(int[][] board, Integer maxColumnLength, int row) {
        boolean[] constraint = new boolean[maxColumnLength];
        return IntStream.range(0, maxColumnLength)
                // Validate all columns for the given row.
                .allMatch(column -> checkConstraint(board, row, column, constraint));
    }

    /**
     * Validate if the current row is in a valid state.
     *
     * @param board        - The board being processed.
     * @param maxRowLength - The max row length.
     * @param column       - The column being validated.
     * @return A boolean indicating if the row is valid.
     */
    private boolean checkConstraintColumn(int[][] board, Integer maxRowLength, int column) {
        boolean[] constraint = new boolean[maxRowLength];
        return IntStream.range(0, maxRowLength)
                // Validate all rows for the given column.
                .allMatch(row -> checkConstraint(board, row, column, constraint));
    }

    private boolean checkConstraintGrid(int[][] board, Integer columns, int row, int column) {
        boolean[] constraint = new boolean[columns];
        // Determine the grid size for board.
        Double grid = Math.sqrt(columns);
        int sudokoGrid = grid.intValue();

        int subsectionRowStart = (row / sudokoGrid) * sudokoGrid;
        int subsectionRowEnd = subsectionRowStart + sudokoGrid;

        int subsectionColumnStart = (column / sudokoGrid) * sudokoGrid;
        int subsectionColumnEnd = subsectionColumnStart + sudokoGrid;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, c, constraint)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validates that the given Row and Column is valid for the given board.
     *
     * @param board      - The board being processed.
     * @param row        - The row to be processed.
     * @param column     - The column to be processed.
     * @param constraint - A boolean array containing indicators if row/column is not 0.
     * @return A boolean indicating the result of the check.
     */
    private boolean checkConstraint(int[][] board, int row, int column, boolean[] constraint) {
        if (board[row][column] != UNMAPPED_VALUE) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
