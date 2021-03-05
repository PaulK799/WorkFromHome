package com.paul.learning.wfh.core.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Test the {@link MergeSort} class.
 */
@SpringBootTest
public class MergeSortTest {

    @Test
    public void basicSort() {
        int[] arr = {7, 5, 3, 1};
        int[] sortedArr = MergeSort.mergeSort(arr);
        int[] expectedArr = {1, 3, 5, 7};
        Assertions.assertTrue(Arrays.equals(expectedArr, sortedArr));
    }

    @Test
    public void simpleSort() {
        int[] arr = {2, 1, 3, 1, 2};
        int[] sortedArr = MergeSort.mergeSort(arr);
        int[] expectedArr = {1, 1, 2, 2, 3};
        Assertions.assertTrue(Arrays.equals(expectedArr, sortedArr));
    }

    @Test
    public void noSort() {
        int[] arr = {1, 1, 1, 2, 2};
        int[] sortedArr = MergeSort.mergeSort(arr);
        int[] expectedArr = {1, 1, 1, 2, 2};
        Assertions.assertTrue(Arrays.equals(expectedArr, sortedArr));
    }
}
