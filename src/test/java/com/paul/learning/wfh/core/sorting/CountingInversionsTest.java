package com.paul.learning.wfh.core.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link CountingInversions} class.
 */
@SpringBootTest
public class CountingInversionsTest {

    @Test
    public void zeroInversionsCountTest() {
        int[] arr = {1, 1, 1, 2, 2};
        long inversions = CountingInversions.countInversions(arr);
        Assertions.assertEquals(0L, inversions);
    }

    @Test
    public void basicInversionsCountTest() {
        int[] arr = {2, 1, 3, 1, 2};
        long inversions = CountingInversions.countInversions(arr);
        Assertions.assertEquals(4L, inversions);
    }

    @Test
    public void alternativeInversionsCountTest() {
        int[] arr = {7, 5, 3, 1};
        long inversions = CountingInversions.countInversions(arr);
        Assertions.assertEquals(6L, inversions);
    }
}
