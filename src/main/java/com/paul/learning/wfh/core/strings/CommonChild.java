package com.paul.learning.wfh.core.strings;

/**
 * A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string.
 * Given two strings of equal length,
 * what's the longest string that can be constructed such that it is a child of both?
 * <p>
 * For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD.
 * They can be formed by eliminating either the D or C from both strings.
 * Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD != ABDC.
 */
public class CommonChild {

    private CommonChild() {
        //Private Constructor.
    }

    /**
     * Returns the longest string which is a common child of the input strings.
     *
     * @param s1 - The first {@link String} to be processed.
     * @param s2 - The second {@link String} to be processed
     * @return The length of the longest {@link String} that can be formed by deleting zero or more characters
     */
    public static int commonChild(String s1, String s2) {
        return longestCommonSequenceDynamicProgramming(s1, s2);
    }

    /**
     * Longest Common Sequence (LCS) algorithm implementation using Recursion.
     *
     * @param s1 - The first {@link String} to be processed.
     * @param s2 - The second {@link String} to be processed.
     * @return The length of the longest common sequence between the two strings provided..
     */
    public static int longestCommonSequenceDynamicProgramming(String s1, String s2) {
        int i;
        int j = 0;

        int s1Len = s1.length();
        int s2Len = s2.length();

        // Initiate 2D Array for storing LCS value.
        int[][] lcs = new int[s1Len + 1][s2Len + 1];

        for (i = 1; i <= s1Len; i++) {
            for (j = 1; j <= s2Len; j++) {
                // If characters match, increment counter for i,j with previous values.
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    //If non matching, use the max highest LCS value between each remaining character array - 1.
                    lcs[i][j] = (Math.max(lcs[i - 1][j], lcs[i][j - 1]));
                }
            }
        }
        //
        return lcs[i - 1][j - 1];
    }

    /**
     * Returns the longest string which is a common child of the input strings.
     *
     * @param s1 - The first {@link String} to be processed.
     * @param s2 - The second {@link String} to be processed
     * @return The length of the longest {@link String} that can be formed by deleting zero or more characters
     */
    public static int commonChildRecursive(String s1, String s2) {
        char[] stringOne = s1.toCharArray();
        char[] stringTwo = s2.toCharArray();

        int stringOneLen = s1.length();
        int stringTwoLen = s2.length();

        // Recursive function to determine the Longest Common Sequence (LCS).
        return longestCommonSequence(stringOne, stringTwo, stringOneLen, stringTwoLen);
    }

    /**
     * Longest Common Sequence (LCS) algorithm implementation using Recursion.
     *
     * @param stringOne    - The first {@link String} to be processed.
     * @param stringTwo    - The second {@link String} to be processed.
     * @param stringOneLen - The length of the first {@link String}.
     * @param stringTwoLen - The length of the second {@link String}.
     * @return The length of the longest common sequence between the two strings provided..
     */
    public static int longestCommonSequence(char[] stringOne, char[] stringTwo, int stringOneLen, int stringTwoLen) {

        // Break out condition.
        if (stringOneLen == 0 || stringTwoLen == 0) {
            return 0;
        }

        int stringOneLenMinusOne = stringOneLen - 1;
        int stringTwoLenMinusOne = stringTwoLen - 1;

        // Work from back to front. If characters match, increment counter and run LCS on the character index -1 for both arrays.
        if (stringOne[stringOneLenMinusOne] == stringTwo[stringTwoLenMinusOne]) {
            return 1 + longestCommonSequence(stringOne, stringTwo, stringOneLenMinusOne, stringTwoLenMinusOne);
        } else {
            // If non matching, use the max highest LCS value between each remaining character array - 1.
            return Math.max(longestCommonSequence(stringOne, stringTwo, stringOneLen, stringTwoLenMinusOne),
                    longestCommonSequence(stringOne, stringTwo, stringOneLenMinusOne, stringTwoLen));
        }
    }
}
