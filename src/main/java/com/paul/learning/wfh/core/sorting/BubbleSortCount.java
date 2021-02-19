package com.paul.learning.wfh.core.sorting;

/**
 * Given an array of integers, sort the array in ascending order using the Bubble Sort algorithm.
 * Once sorted, print the following three lines:
 * <p>
 * Array is sorted in numSwaps swaps., where "numSwaps" is the number of swaps that took place.
 * First Element: firstElement, where "firstElement" is the first element in the sorted array.
 * Last Element: lastElement, where "lastElement" is the last element in the sorted array.
 */
public class BubbleSortCount {

    private BubbleSortCount() {
        // Private Constructor
    }

    static void countSwaps(int[] a) {
        int n = a.length;

        int swaps = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {

                    // Swap arr[j+1] and arr[j]
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swaps++;
                }
            }
        }

        System.out.println("Array is sorted in " + swaps + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n - 1]);
    }
}
