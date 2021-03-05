package com.paul.learning.wfh.core.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        List<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> sortedList = mergeSort(arrayList);
        return sortedList.stream()
                .mapToInt(i -> (i == null ? 0 : i))
                .toArray();
    }

    /**
     * Performs Merge sort algorithm to sort the input value.
     *
     * @param array - Array list to be sorted.
     * @return The sorted list.
     */
    private static List<Integer> mergeSort(List<Integer> array) {
        int length = array.size();
        // If single item remaining.
        if (length <= 1) {
            return array;
        }

        // Split Array in half.
        List<Integer> leftArray = getSubArray(array, 0, length / 2);
        // Recursively sort left half array
        leftArray = mergeSort(leftArray);

        List<Integer> rightArray = getSubArray(array, length / 2, length);
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
    private static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
        int leftArrayLen = leftList.size();
        int rightArrayLen = rightList.size();

        // Empty Left List
        if (leftArrayLen <= 0) {
            return rightList;
        }

        // Empty Right List
        if (rightArrayLen <= 0) {
            return leftList;
        }

        // If first element of Left Array is lexicographically less than or equal to first element of Right Array
        if (leftList.get(0).compareTo(rightList.get(0)) <= 0) {
            // Get Left Array (minus first element)
            List<Integer> reducedLeftArray = getSubArray(leftList, 1, leftArrayLen);
            // Merge reduced left array with right array using Recursive method.
            List<Integer> mergedArray = merge(reducedLeftArray, rightList);
            // Push first element of left array to the left.
            return combine(leftList.get(0), mergedArray);
        } else {
            // Get Right Array (minus first element)
            List<Integer> reducedRightArray = getSubArray(rightList, 1, rightArrayLen);
            // Merge left array with reduced array using Recursive method.
            List<Integer> mergedArray = merge(leftList, reducedRightArray);
            // Push first element of right array to the left.
            return combine(rightList.get(0), mergedArray);
        }
    }

    /**
     * Aggregates two {@link List} together.
     *
     * @param leftArray  - The left {@link List} to be concatenated together.
     * @param rightArray - The right {@link List} to be concatenated together.
     * @return The aggregated {@link int[]}.
     */
    private static List<Integer> combine(int leftArray, List<Integer> rightArray) {
        List<Integer> combinedList = new ArrayList<>();
        combinedList.add(leftArray);
        combinedList.addAll(rightArray);
        return combinedList;
    }

    /**
     * Creates a {@link int[]}  from the start and end index of the original {@link int[]}
     *
     * @param originalList - The original {@link int[]} being processed.
     * @param start        - The start index being processed.
     * @param end          - The end index being processed.
     * @return The split {@link int[]}
     */
    private static List<Integer> getSubArray(List<Integer> originalList, int start, int end) {
        try {
            return new ArrayList<>(originalList.subList(start, end));
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | IllegalArgumentException exception) {
            // Eat Exception for HackerRank.
        }
        return originalList;
    }
}
