package com.paul.learning.wfh.core.sorting;

import java.util.Arrays;

/**
 * <p>
 * Mark and Jane are very happy after having their first child.
 * Their son loves toys, so Mark wants to buy some.
 * There are a number of different toys lying in front of him, tagged with their prices.
 * Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.
 * Given a list of toy prices and an amount to spend, determine the maximum number of gifts he can buy.
 * </p>
 * <p>
 * Note Each toy can be purchased only once.
 * </p>
 */
public class MarksToys {

    private MarksToys() {
        // Private Constructor
    }

    /**
     * @param prices - Prices of each toy available.
     * @param k      - Budget to spend.
     * @return The maximum amount of toys purchasable with budget.
     */
    public static int maximumToys(int[] prices, int k) {
        int maxToys = 0;

        int balance = k;
        int[] sortedArray = prices;
        Arrays.sort(sortedArray);

        for (int i =0; i < sortedArray.length; i++) {
            if (balance == 0) {
                break;
            }

            int value = sortedArray[i];
            if (balance - value >= 0) {
                balance = balance - value;
                maxToys++;
            }
        }

        return maxToys;
    }
}
