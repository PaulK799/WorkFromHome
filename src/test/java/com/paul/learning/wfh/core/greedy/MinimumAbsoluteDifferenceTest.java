package com.paul.learning.wfh.core.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test the {@link MinimumAbsoluteDifference} class.
 */
public class MinimumAbsoluteDifferenceTest {

    /**
     * Test the {@link MinimumAbsoluteDifference#minimumAbsoluteDifference(List)} method with a given input.
     */
    @Test
    public void minAbsDifferenceBasicCaseOne() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(-59, -36, -13, 1,-53,-92,-2,-96, -54, 75));
        int acctualDifference = MinimumAbsoluteDifference.minimumAbsoluteDifference(arr);
        Assertions.assertEquals(1, acctualDifference);
    }

    /**
     * Test the {@link MinimumAbsoluteDifference#minimumAbsoluteDifference(List)} method with a given input.
     */
    @Test
    public void minAbsDifferenceBasicCaseTwo() {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, -3, 71, 68, 17));
        int acctualDifference = MinimumAbsoluteDifference.minimumAbsoluteDifference(arr);
        Assertions.assertEquals(3, acctualDifference);
    }
}
