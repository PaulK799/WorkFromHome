package com.paul.learning.wfh.recursion.service;

import com.paul.learning.wfh.patterns.creational.prototype.Position;
import com.paul.learning.wfh.recursion.input.FloodFillInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * A Service for performing the Flood Fill algorithm.
 */
@Service
public class FloodFillService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FloodFillService.class);

    public FloodFillInput floodFill(FloodFillInput floodFillInput) {
        floodFillInput = fill(floodFillInput);
        return floodFillInput;
    }

    /**
     * Flood fill implementation using a {@link Queue}.
     *
     * @param floodFillInput - The {@link FloodFillInput} being processed.
     * @return The updated image.
     */
    public FloodFillInput fill(FloodFillInput floodFillInput) {
        int[][] imageToFill = floodFillInput.getImage();
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(floodFillInput.getPosition());

        int row;
        int column;

        int cols = imageToFill.length - 1;
        int rows = imageToFill[0].length - 1;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            row = position.getXAxis();
            column = position.getYAxis();

            int currentColor = imageToFill[row][column];
            if (currentColor == floodFillInput.getOriginalColor()) {
                // Replace Color at current position.
                imageToFill[row][column] = floodFillInput.getNewColor();

                // North (x-1, y)
                if (row > 0) {
                    queue.add(new Position(row - 1, column));
                }

                // South (x+1,y)
                if (row < rows) {
                    queue.add(new Position(row + 1, column));
                }

                // West (x, y-1)
                if (column > 0) {
                    queue.add(new Position(row, column - 1));
                }

                // East (x, y + 1)
                if (column < cols) {
                    queue.add(new Position(row, column + 1));
                }
            }
        }
        return floodFillInput;
    }
}
