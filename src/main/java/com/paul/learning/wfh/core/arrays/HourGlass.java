package com.paul.learning.wfh.core.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Computes the maximum summed hourglass in a 2D Array.
 */
public class HourGlass {
    private static final Logger LOGGER = LoggerFactory.getLogger(HourGlass.class);
    private static final int MAX_HOUR_GLASS = 7;

    private HourGlass() {
        // Private Constructor
    }

    public static int hourglassSum(int[][] arr) {
        int sum = Integer.MIN_VALUE;
        if (arr != null) {
            int rows = arr.length;
            int columns = arr[0].length;
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    if (isHourGlass(rows, columns, row, column)) {
                        int hourGlassSum = getHourGlass(arr, row, column);
                        if (hourGlassSum > sum) {
                            sum = hourGlassSum;
                        }
                    }
                }
            }
        }

        return sum;
    }

    /**
     * Checks if from current position an hourglass is possible.
     *
     * @param rows        - The maximum row length.
     * @param columns     - The maximum column length.
     * @param rowStart    - The starting row position for the hourglass.
     * @param columnStart - The starting column position for the hourglass.
     * @return The total.
     */
    private static boolean isHourGlass(int rows, int columns, int rowStart, int columnStart) {
        boolean[] constraints = new boolean[MAX_HOUR_GLASS];
        try {
            constraints[0] = isValidPosition(rows, columns, rowStart, columnStart);
            constraints[1] = isValidPosition(rows, columns, rowStart + 1, columnStart);
            constraints[2] = isValidPosition(rows, columns, rowStart + 2, columnStart);
            constraints[3] = isValidPosition(rows, columns, rowStart + 1, columnStart + 1);
            constraints[4] = isValidPosition(rows, columns, rowStart, columnStart + 2);
            constraints[5] = isValidPosition(rows, columns, rowStart + 1, columnStart + 2);
            constraints[6] = isValidPosition(rows, columns, rowStart + 2, columnStart + 2);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return validateConstraints(constraints);
    }

    /**
     * Validates all constraints in array.
     *
     * @param constraints - The constraint array to be validated.
     * @return The result.
     */
    private static boolean validateConstraints(boolean[] constraints) {
        if (constraints != null) {
            for (boolean constraint : constraints) {
                if (!constraint) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if current position in hourglass is possible.
     *
     * @param rows        - The maximum row length.
     * @param columns     - The maximum column length.
     * @param rowStart    - The starting row position for the hourglass.
     * @param columnStart - The starting column position for the hourglass.
     * @return The total.
     */
    private static boolean isValidPosition(int rows, int columns, int rowStart, int columnStart) {
        return (rowStart >= 0 && rowStart < rows && columnStart >= 0 && columnStart < columns);
    }

    /**
     * Returns the total for the Hour Glass.
     *
     * @param arr    - The hourglass array being processed.
     * @param row    - The starting row position for the hourglass.
     * @param column - The starting column position for the hourglass.
     * @return The total.
     */
    private static int getHourGlass(int[][] arr, int row, int column) {
        int total = 0;
        total += getValue(arr, row, column);
        total += getValue(arr, row + 1, column);
        total += getValue(arr, row + 2, column);
        total += getValue(arr, row + 1, column + 1);
        total += getValue(arr, row, column + 2);
        total += getValue(arr, row + 1, column + 2);
        total += getValue(arr, row + 2, column + 2);
        return total;
    }

    private static int getValue(int[][] arr, int row, int column) {
        int value = 0;
        try {
            value = arr[column][row];
        } catch (IndexOutOfBoundsException e) {
            //
        }

        return value;
    }
}
