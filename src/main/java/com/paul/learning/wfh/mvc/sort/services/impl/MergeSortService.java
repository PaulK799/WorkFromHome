package com.paul.learning.wfh.mvc.sort.services.impl;

import com.paul.learning.wfh.mvc.sort.services.SortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * A class for implementing merge sort.
 */
@Service
public class MergeSortService implements SortService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergeSortService.class);
    private static final String EMPTY = "";

    /**
     * Implementation of the sort function.
     *
     * @param value - The {@link String} value to be sorted.
     * @return The sorted {@link String} using merge sort.
     */
    @Override
    public String sort(String value) {
        LOGGER.info("Starting Merge Sort");
        String[] valueList = value.split(EMPTY);
        String[] sortedList = mergeSort(valueList);
        return String.join(EMPTY, sortedList);
    }

    /**
     * Performs Merge sort algorithm to sort the input value.
     *
     * @param array - Array list to be sorted.
     * @return The sorted list.
     */
    private String[] mergeSort(String[] array) {
        int length = array.length;
        // If single item remaining.
        if (length <= 1) {
            return array;
        }

        // Split Array in half.
        String[] leftArray = getSubArray(array, 0, length / 2);
        // Recursively sort left half array
        leftArray = mergeSort(leftArray);

        String[] rightArray = getSubArray(array, length / 2, length);
        // Recursively sort right half array
        rightArray = mergeSort(rightArray);

        // Merge Sorted arrays
        return merge(leftArray, rightArray);
    }

    /**
     * Merge two sorted lists together.
     *
     * @param leftArray  - The left {@link String[]} being processed.
     * @param rightArray - The right {@link String[]} being processed.
     * @return The sorted {@link String[]}.
     */
    private String[] merge(String[] leftArray, String[] rightArray) {
        int leftArrayLen = leftArray.length;
        int rightArrayLen = rightArray.length;

        // Empty Left Array
        if (leftArrayLen <= 0) {
            return rightArray;
        }

        // Empty Right Array
        if (rightArrayLen <= 0) {
            return leftArray;
        }

        // If first element of Left Array is lexicographically less than or equal to first element of Right Array
        if (leftArray[0].compareTo(rightArray[0]) <= 0) {
            // Get Left Array (minus first element)
            String[] reducedLeftArray = getSubArray(leftArray, 1, leftArrayLen);
            // Merge reduced left array with right array using Recursive method.
            String[] mergedArray = merge(reducedLeftArray, rightArray);
            // Push first element of left array to the left.
            return combine(leftArray[0], mergedArray);
        } else {
            // Get Right Array (minus first element)
            String[] reducedRightArray = getSubArray(rightArray, 1, rightArrayLen);
            // Merge left array with reduced array using Recursive method.
            String[] mergedArray = merge(leftArray, reducedRightArray);
            // Push first element of right array to the left.
            return combine(rightArray[0], mergedArray);
        }
    }

    /**
     * Aggregates two {@link String[]} together.
     *
     * @param leftArray  - The left {@link String[]} to be concatenated together.
     * @param rightArray - The right {@link String[]} to be concatenated together.
     * @return The aggregated {@link String[]}.
     */
    private String[] combine(String leftArray, String[] rightArray) {
        return Stream.of(new String[]{leftArray}, rightArray)
                .flatMap(Stream::of)
                .toArray(String[]::new);
    }

    /**
     * Creates a {@link String[]}  from the start and end index of the original {@link String[]}
     *
     * @param originalList - The original {@link String[]} being processed.
     * @param start        - The start index being processed.
     * @param end          - The end index being processed.
     * @return The split {@link String[]}
     */
    private String[] getSubArray(String[] originalList, int start, int end) {
        try {
            return Arrays.copyOfRange(originalList, start, end);
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | IllegalArgumentException exception) {
            LOGGER.error("Unable to getSubArray for array list due to exception {0}", exception);
        }
        return originalList;
    }
}
