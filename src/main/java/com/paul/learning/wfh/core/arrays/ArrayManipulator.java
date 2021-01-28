package com.paul.learning.wfh.core.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Starting with a 1-indexed array of zeros and a list of operations,
 * for each operation add a value to each the array element between two given indices, inclusive.
 * Once all operations have been performed,
 * return the maximum value in the array.
 */
public class ArrayManipulator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayManipulator.class);

    private ArrayManipulator() {
    }

    public static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 2];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            try {
                // Add value to start and deduct from end index + 1 to ensure complete.
                int value = queries[i][2];
                arr[start] += value;
                arr[end + 1] -= value;
            } catch (ArrayIndexOutOfBoundsException e) {
                LOGGER.error("Not in valid format.");
            }
        }
        return getMax(arr);
    }

    private static long getMax(long[] inputArray) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < inputArray.length; i++) {
            sum += inputArray[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
