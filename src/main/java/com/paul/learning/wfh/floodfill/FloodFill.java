package com.paul.learning.wfh.floodfill;

import com.paul.learning.wfh.patterns.creational.prototype.Position;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

import static com.paul.learning.wfh.constants.GlobalConstants.STRING_NEW_LINE;

/**
 * A class which solves the flood fill algorithm.
 */
public class FloodFill {

    private int[][] image;

    /**
     * Constructor for {@link FloodFill}.
     *
     * @param image - The 2-D Image to be filled.
     */
    public FloodFill(int[][] image) {
        this.image = image;
    }

    /**
     * Flood fill implementation using a {@link Queue}.
     *
     * @param row           - The starting Position on x-axis.
     * @param column        - Th starting Position on y-axis.
     * @param originalColor - The original color to be replaced.
     * @param newColor      - The new color to be replaced.
     * @return The updated image.
     */
    public int[][] fill(int row, int column, int originalColor, int newColor) {
        int[][] imageToFill = getImage();
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(row, column));

        int startRow = row;
        int startCol = column;

        int cols = imageToFill.length - 1;
        int rows = imageToFill[0].length - 1;

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            row = position.getXAxis();
            column = position.getYAxis();

            int currentColor = imageToFill[row][column];
            if (currentColor == originalColor) {

                if (startRow == row && startCol == column) {
                    imageToFill[row][column] = 4;
                } else {
                    // Replace Color at current position.
                    imageToFill[row][column] = newColor;
                }

                // North (x-1, y)
                Position north = new Position(row - 1, column);
                if (row > 0 && !queue.contains(north) && imageToFill[north.getXAxis()][north.getYAxis()] == originalColor) {
                    queue.add(north);
                }

                // South (x+1,y)
                Position south = new Position(row + 1, column);
                if (row < rows && !queue.contains(south) && imageToFill[south.getXAxis()][south.getYAxis()]  == originalColor) {
                    queue.add(south);
                }

                Position west = new Position(row, column - 1);
                // West (x, y-1)
                if (column > 0 && !queue.contains(west) && imageToFill[west.getXAxis()][west.getYAxis()] == originalColor) {
                    queue.add(west);
                }

                // East (x, y + 1)
                Position east = new Position(row, column + 1);
                if (column < cols && !queue.contains(east) && imageToFill[east.getXAxis()][east.getYAxis()] == originalColor) {
                    queue.add(east);
                }
            }
        }
        return getImage();
    }

    /**
     * Returns the image.
     *
     * @return The {@link int[][]} to be processed.
     */
    public int[][] getImage() {
        return image;
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
        int[][] imageToOutput = getImage();
        for (int[] row : imageToOutput) {
            stringBuilder.append(Arrays.toString(row));
            stringBuilder.append(STRING_NEW_LINE);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
