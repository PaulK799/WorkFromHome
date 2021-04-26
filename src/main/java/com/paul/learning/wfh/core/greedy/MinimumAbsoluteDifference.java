package com.paul.learning.wfh.core.greedy;

import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {

    /*
     * Complete the 'minimumAbsoluteDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int difference = Integer.MAX_VALUE;

        // Sort the array.
        Collections.sort(arr);

        for (int i = arr.size() - 1; i > 0 ; i--) {
            difference = Math.min(Math.abs(arr.get(i) - arr.get(i -1)), difference);
        }
        return difference;
    }
}
