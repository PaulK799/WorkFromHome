package com.paul.learning.wfh.core.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A string is said to be a special string if either of two conditions is met:
 * All of the characters are the same, e.g. aaa.
 * All characters except the middle one are the same, e.g. aadaa.
 * <p>
 * A special substring is any substring of a string which meets one of those criteria.
 * Given a string, determine how many special substrings can be formed from it.
 * For example, given the string s= "mnonopoo", we have the following special substrings:
 * {m, n, o, n, o, p, o, o, non, ono, opo, oo }
 */
public class SpecialStringsAgain {

    private SpecialStringsAgain() {
        // Private Constructor
    }

    static long substrCount(int n, String s) {
        long count = 0L;
        int[] numRepeatedMap = new int[s.length()];

        // Case 1: All same characters
        for (int i = 0; i < n; ) {
            // count number of times a character is repeatedCharacterCounter.
            long repeatedCharacterCounter = 1;

            // Used to increment "i" to the location of j after processing to skip repeated characters..
            int indexPlusOneCounter = i + 1;
            for (int j = indexPlusOneCounter; j <n; j++) {
                char current = s.charAt(j);
                char previous = s.charAt(j -1);

                // If identical, increment counter and move position.
                if (current == previous) {
                    repeatedCharacterCounter++;
                    indexPlusOneCounter++;
                } else {
                    break;
                }

            }
            count += (repeatedCharacterCounter * (repeatedCharacterCounter + 1)) / 2;
            // For a string like aaabaa, this will look like 300120.
            numRepeatedMap[i] = (int) repeatedCharacterCounter;


            i = indexPlusOneCounter;
        }

        // Case 2: All characters except the middle one are same
        for (int j = 1; j < n - 1; j++) {
            char current = s.charAt(j);
            char previous = s.charAt(j -1);
            char next = s.charAt(j + 1);

            if (current == previous) {
                // Fix the array storing number of times characters are repeated.
                numRepeatedMap[j] = numRepeatedMap[j - 1];
                continue;
            }

            if (previous == next) {
                count += Math.min(numRepeatedMap[j + 1], numRepeatedMap[j - 1]);
            }
        }

        return count;
    }


    /**
     * Returns the number of Special Substrings contained in the String.
     *
     * @param n - The length of the {@link String} s.
     * @param s - The {@link String} to be processed.
     * @return The number of Special Substrings.
     */
    public static long substrCountBruteForce(int n, String s) {
        long matchingCounter = 0L;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String subStr = s.substring(i, j);

                // Check all sub strings if same OR All characters except the middle one are the same.
                if (subStr.length() > 1 && (isAllCharsSame(subStr) || isAllCharsPivotMiddleSame(subStr))) {
                    matchingCounter++;
                }
            }
        }

        return matchingCounter + n;
    }

    /**
     * Determine if {@link String} contains a single value.
     *
     * @param text - The {@link String} to be processed.
     * @return A boolean indicating if all characters in String at the same.
     */
    public static boolean isAllCharsSame(String text) {
        Set<String> textSet = new HashSet<>(Arrays.asList(text.split("")));
        return textSet.size() == 1;
    }

    /**
     * Determine if {@link String} contains a single value.
     *
     * @param text - The {@link String} to be processed.
     * @return A boolean indicating if all characters in String at the same.
     */
    public static boolean isAllCharsPivotMiddleSame(String text) {
        int length = text.length() - 1;
        int pivot = Math.max(length / 2, 0);
        if (text.length() > 2) {
            List<String> list = new LinkedList<>(Arrays.asList(text.split("")));
            list.remove(pivot);
            Set<String> removedList = new HashSet<>(list);
            return removedList.size() == 1;
        }
        return false;
    }
}
