package com.paul.learning.wfh.puzzles.sudoku.services;

import com.paul.learning.wfh.puzzles.sudoku.input.SudokuInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * A test for the {@link SudokuService} class.
 */
@SpringBootTest
public class SudokuServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SudokuServiceTest.class);

    @InjectMocks
    private SudokuService sudokuService;

    /**
     * A test to verify the solving of the given board to the {@link SudokuService}.
     */
    @Test
    public void solveSudokuBoard() {
        int[][] board = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };

        SudokuInput input = new SudokuInput();
        input.setBoard(board);

        int[][] expectedBoard = {
                { 8, 1, 2, 7, 5, 3, 6, 4, 9 },
                { 9, 4, 3, 6, 8, 2, 1, 7, 5 },
                { 6, 7, 5, 4, 9, 1, 2, 8, 3 },
                { 1, 5, 4, 2, 3, 7, 8, 9, 6 },
                { 3, 6, 9, 8, 4, 5, 7, 2, 1 },
                { 2, 8, 7, 1, 6, 9, 5, 3, 4 },
                { 5, 2, 1, 9, 7, 4, 3, 6, 8 },
                { 4, 3, 8, 5, 2, 6, 9, 1, 7 },
                { 7, 9, 6, 3, 1, 8, 4, 5, 2 }
        };

        LOGGER.info("Before: {}", input.toString());
        input = sudokuService.solve(input);
        LOGGER.info("After: {}", input.toString());
        Assertions.assertTrue(Arrays.deepEquals(expectedBoard, input.getBoard()));
    }
}
