package com.paul.learning.wfh.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * A class which performs the Sum Pair action.
 */
public class SumPair {

    /**
     * A private default constructor for the {@link SumPair} class.
     */
    private SumPair() {
        //
    }

    /**
     * Given array of integers and a target n.
     *
     * @param arr    - An array of ints to be processed.
     * @param target - The target value.
     * @return True if there is a pair that sums to that target. False if none exist.
     */
    public static boolean isPairEqual(int[] arr, int target) {
        Set<Integer> values = new HashSet<>();
        // Iterate through each element in array
        for (int index = 0; index < arr.length; index++) {
            int currentValue = arr[index];
            int remaining = target - currentValue;

            if (values.contains(remaining)) {
                return true;
            }
            values.add(currentValue);
        }

        return false;
    }
}
