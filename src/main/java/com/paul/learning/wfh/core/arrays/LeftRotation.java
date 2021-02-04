package com.paul.learning.wfh.core.arrays;

import java.util.Arrays;

/**
 * Left Rotation array problem.
 */
public class LeftRotation {

    private LeftRotation() {
        // Hide constructor.
    }

    /**
     * Rotates the array to the left based on the number of rotations.
     *
     * @param a - The Array to be rotated.
     * @param d - The number of rotations.
     * @return The rotated Array.
     */
    public static int[] rotLeft(int[] a, int d) {
        // Sanitize the request to ensure unnecessary processing avoided.
        if (d <= 0 || a == null || a.length <= 1) {
            return a;
        }

        // Copy array for processing.
        int[] copyArr = Arrays.copyOf(a, a.length);
        // Iterate through the array
        for (int i = 0; i < a.length; i++) {
            // Replace the value in the current location "d" locations across the array.
            // Use Modulus to get the remainder to shift the value X places.
            int tempIndex = (i + d) % a.length;
            copyArr[i] = a[tempIndex];
        }
        return copyArr;
    }
}
