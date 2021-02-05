package com.paul.learning.wfh.core.arrays;

import java.util.Arrays;

/**
 * Problem:
 * Each person wears a sticker indicating their initial position in the queue from 1 to n.
 * Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker.
 * One person can bribe at most two others.
 * Determine the minimum number of bribes that took place to get to a given queue order.
 * Print the number of bribes, or, if anyone has bribed more than two people, print Too chaotic.
 */
public class NewYearsChaos {

    private NewYearsChaos() {
        // private constructor to prevent initialization.
    }

    /**
     * Method to print the number of bribes, or if anyone has bribed more than too, print "Too  chaotic".
     *
     * @param q - The array to be processed.
     */
    static void minimumBribes(int[] q) {
        boolean isChaotic = false;
        int bribeCount = 0;

        // Copy Queue for manipulation and processing.
        int[] queue = Arrays.copyOf(q, q.length);

        // Iterate through the queue in reverse.
        for (int index = queue.length - 1; index >= 0; index--) {
            int sticker = queue[index];

            // If final position is more than 2, then bribed more than two people. Therefore print chaotic.
            if (sticker - (index + 1) > 2) {
                isChaotic = true;
                break;
            }

            // Ensures no IndexOutOfRangeException.
            int startPos = Math.max(0, sticker - 2);

            // Check from index of Sticker - 2 to the range of current index if value is greater than sticker.
            for (int j = startPos; j < index; j++) {
                if (q[j] > sticker) {
                    bribeCount++;
                }
            }
        }

        // Check is Chaotic or print number of bribes.
        if (isChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribeCount);
        }
    }
}
