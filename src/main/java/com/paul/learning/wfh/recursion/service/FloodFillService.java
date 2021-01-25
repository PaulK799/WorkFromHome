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
        LOGGER.info("Starting Flood Fill");
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

        int startRow = floodFillInput.getPosition().getXAxis();
        int startCol = floodFillInput.getPosition().getYAxis();

        int cols = imageToFill.length - 1;
        int rows = imageToFill[0].length - 1;

        int iterations = 0 ;
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            row = position.getXAxis();
            column = position.getYAxis();

            int currentColor = imageToFill[row][column];
            if (currentColor == floodFillInput.getOriginalColor()) {

                if (startRow == row && startCol == column) {
                    imageToFill[row][column] = 4;
                } else {
                    // Replace Color at current position.
                    imageToFill[row][column] = floodFillInput.getNewColor();
                }

                // North (x-1, y)
                Position north = new Position(row - 1, column);
                if (row > 0 && !queue.contains(north) && imageToFill[north.getXAxis()][north.getYAxis()] == floodFillInput.getOriginalColor()) {
                    queue.add(north);
                }

                // South (x+1,y)
                Position south = new Position(row + 1, column);
                if (row < rows && !queue.contains(south) && imageToFill[south.getXAxis()][south.getYAxis()]  == floodFillInput.getOriginalColor()) {
                    queue.add(south);
                }

                Position west = new Position(row, column - 1);
                // West (x, y-1)
                if (column > 0 && !queue.contains(west) && imageToFill[west.getXAxis()][west.getYAxis()] == floodFillInput.getOriginalColor()) {
                    queue.add(west);
                }

                // East (x, y + 1)
                Position east = new Position(row, column + 1);
                if (column < cols && !queue.contains(east) && imageToFill[east.getXAxis()][east.getYAxis()] == floodFillInput.getOriginalColor()) {
                    queue.add(east);
                }
            }
            iterations++;
        }
        floodFillInput.setIterations(iterations);
        return floodFillInput;
    }
}
