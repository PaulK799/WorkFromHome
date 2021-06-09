package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumPairTest {

    @Test
    public void basicSumPairSuccess() {
        int[] arr = {1, 3, 4, 5, 2, 8};
        boolean isValid = SumPair.isPairEqual(arr, 6);
        Assertions.assertTrue(isValid, "A pair matching the given target is available.");
    }

    @Test
    public void additionalSumPairSuccess() {
        int[] arr = {-5, 1, -40, 20, 6, 8, 7};
        boolean isValid = SumPair.isPairEqual(arr, 15);
        Assertions.assertTrue(isValid, "A pair matching the given target is available.");
    }

    @Test
    public void sumPairInvalid() {
        int[] arr = {-5, 4, -2, 16, 8, 9};
        boolean isValid = SumPair.isPairEqual(arr, 15);
        Assertions.assertFalse(isValid, "A pair matching the given target is available.");
    }
}
