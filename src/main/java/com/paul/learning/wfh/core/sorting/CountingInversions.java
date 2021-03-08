package com.paul.learning.wfh.core.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CountingInversions {

    public static long inversions =0L;

    private CountingInversions() {
        // Private Constructor
    }

    public static long countInversions(int[] arr) {
        inversions = 0L;
        mergeSort(arr);
        return inversions;
    }

    /**
     * Performs Merge sort algorithm to sort the input value.
     *
     * @param array - Array list to be sorted.
     * @return The sorted list.
     */
    private static int[] mergeSort(int[] array) {
        int length = array.length;
        // If single item remaining.
        if (length <= 1) {
            return array;
        }

        // Split Array in half.
        int[] leftArray = getSubArray(array, 0, length / 2);
        // Recursively sort left half array
        leftArray = mergeSort(leftArray);

        int[] rightArray = getSubArray(array, length / 2, length);
        // Recursively sort right half array
        rightArray = mergeSort(rightArray);

        // Merge Sorted arrays
        return merge(leftArray, rightArray);
    }

    /**
     * Merge two sorted lists together.
     *
     * @param leftList  - The left {@link List} being processed.
     * @param rightList - The right {@link List} being processed.
     * @return The sorted {@link int[]}.
     */
    private static int[] merge(int[] leftList, int[] rightList) {
        int leftArrayLen = leftList.length;
        int rightArrayLen = rightList.length;

        // Empty Left List
        if (leftArrayLen <= 0) {
            return rightList;
        }

        // Empty Right List
        if (rightArrayLen <= 0) {
            return leftList;
        }

        // If first element of Left Array less than or equal to first element of Right Array
        if (leftList[0] <= rightList[0]) {
            // Get Left Array (minus first element)
            int[] reducedLeftArray = getSubArray(leftList, 1, leftArrayLen);
            // Merge reduced left array with right array using Recursive method.
            int[] mergedArray = merge(reducedLeftArray, rightList);
            // Push first element of left array to the left.
            return combine(leftList[0], mergedArray);
        } else {
            // Get Right Array (minus first element)
            int[] reducedRightArray = getSubArray(rightList, 1, rightArrayLen);
            // Merge left array with reduced array using Recursive method.
            int[] mergedArray = merge(leftList, reducedRightArray);
            // Push first element of right array to the left.
            int[] combinedList = combine(rightList[0], mergedArray);
            inversions += leftArrayLen;
            return combinedList;
        }
    }

    /**
     * Aggregates two {@link List} together.
     *
     * @param leftArray  - The left {@link List} to be concatenated together.
     * @param rightArray - The right {@link List} to be concatenated together.
     * @return The aggregated {@link int[]}.
     */
    private static int[] combine(int leftArray, int[] rightArray) {
        return IntStream.concat(IntStream.of(leftArray), IntStream.of(rightArray)).toArray();
    }

    /**
     * Creates a {@link int[]}  from the start and end index of the original {@link int[]}
     *
     * @param originalList - The original {@link int[]} being processed.
     * @param start        - The start index being processed.
     * @param end          - The end index being processed.
     * @return The split {@link int[]}
     */
    private static int[] getSubArray(int[] originalList, int start, int end) {
        try {
            return Arrays.copyOfRange(originalList, start, end);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | IllegalArgumentException exception) {
            // Eat Exception for HackerRank.
        }
        return originalList;
    }
}
