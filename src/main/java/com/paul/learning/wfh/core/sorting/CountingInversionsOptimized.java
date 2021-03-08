package com.paul.learning.wfh.core.sorting;

import java.util.Arrays;

/**
 * In an array, arr, the elements at indices i and j (where i <= j ) form an inversion if arr[i]  > arr[j].
 * In other words, inverted elements arr[i] and arr[j] are considered to be "out of order".
 * To correct an inversion, we can swap adjacent elements.
 */
public class CountingInversionsOptimized {

    private CountingInversionsOptimized() {
        // Private Constructor
    }

    private static long inversions = 0L;

    /**
     * Performs Merge sort algorithm to sort the input value.
     *
     * @param arr - Array list to be sorted.
     * @return The number of inversions needed to swap all elements.
     */
    public static long countInversions(int[] arr) {
        inversions = 0L;
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        return inversions;
    }

    /**
     * Merge sort traditional implementation.
     *
     * @param arr   - The Array being processed.
     * @param temp  - A temp array to be processed.
     * @param start - The starting index to be processed..
     * @param end   - The end index to be processed.
     */
    private static void mergeSort(int[] arr, int[] temp, int start, int end) {
        if (start < end) {
            // Pivot Array index in half to get mid point.
            int pivot = (start + end) / 2;

            // Recursively sort left half array
            mergeSort(arr, temp, start, pivot);

            // Recursively sort right half array
            mergeSort(arr, temp, pivot + 1, end);

            // Merge Sorted arrays
            merge(arr, temp, start, pivot, end);
        }
    }

    /**
     * @param arr   - The Array being processed.
     * @param temp  - A temp array to be processed.
     * @param pivot - The middle pivot of the array.
     * @param start - The starting index to be processed..
     * @param end   - The end index to be processed.
     */
    private static void merge(int[] arr, int[] temp, int start, int pivot, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }

        int curr = start;
        int left = start;
        int right = pivot + 1;

        while (left <= pivot && right <= end) {
            if (temp[left] <= temp[right]) {
                arr[curr++] = temp[left++];
            } else {
                // Each time we choose element from right side, we count up how many elements it is less than from left side. This is equivalent to counting swaps.
                inversions += pivot + 1 - left;
                arr[curr++] = temp[right++];
            }
        }

        while (left <= pivot) {
            arr[curr++] = temp[left++];
        }
    }
}
