package com.paul.learning.wfh.core.strings;

/**
 * You are given a string containing characters A and B only.
 * Your task is to change it into a string such that there are no matching adjacent characters.
 * To do this, you are allowed to delete zero or more characters in the string.
 * <p>
 * Your task is to find the minimum number of required deletions.
 */
public class AlternativeCharacters {

    private AlternativeCharacters() {
        // Private Constructor.
    }

    /**
     * The minimum of required deletions so that there are no matching adjacent characters.
     *
     * @param s - The {@link String} to be processed.
     * @return The minimum number of deletions required.
     */
    static int alternatingCharacters(String s) {
        int value = 0;
        String[] process = s.split("");
        for (int i = 0; i < process.length - 1; i++) {
            String character = process[i];
            String nextCharacter = process[i + 1];

            // Compare the current character and the next.
            // Increment deletion counter if equal.
            if (character.equals(nextCharacter)) {
                value++;
            }
        }
        return value;
    }
}
