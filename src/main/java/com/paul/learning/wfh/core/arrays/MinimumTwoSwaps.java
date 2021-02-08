package com.paul.learning.wfh.core.arrays;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements.
 * You need to find the minimum number of swaps required to sort the array in ascending order.
 * <p>
 * For example, given the array  we perform the following steps:
 */
public class MinimumTwoSwaps {

    private MinimumTwoSwaps() {
        // Private Constructor to prevent initialization.
    }

    /**
     * Calculate the minimum number of swaps required to sort the array.
     *
     * @param arr - The integer array to be processed.
     * @return The minimum number of swaps.
     */
    public static int minimumSwaps(int[] arr) {
        int swaps = 0;

        // Clone the array for processing.
        int[] process = arr.clone();
        // Sort the array.
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> sortedMap = new HashMap<>();

        // Create Map of value to index for quick reference of where to swap value.
        for (int i = 0; i < sorted.length; i++) {
            // Current and Sorted values for comparison.
            int sortedValue = sorted[i];
            // Store value in map.
            sortedMap.put(sortedValue, i);
        }

        // Process the array.
        for (int i = 0; i < process.length; i++) {
            int currentValue = process[i];

            // Final Location of the index
            int finalIndex = sortedMap.get(currentValue);
            // Current location is not the final location
            if (i != finalIndex) {
                // First Swap the current Value to final location
                int tempValue = process[finalIndex];
                process[finalIndex] = process[i];
                process[i] = tempValue;
                swaps++;
                // Go back one element in loop to ensure all iterations covered.
                // Note, only done for solving this particular algorithm.
                // Not something that would be done day to day.
                i--;
            }

        }

        return swaps;
    }
}
