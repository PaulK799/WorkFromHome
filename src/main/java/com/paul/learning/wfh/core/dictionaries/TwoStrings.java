package com.paul.learning.wfh.core.dictionaries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.paul.learning.wfh.constants.GlobalConstants.SEPARATOR;

/**
 * Given two strings, determine if they share a common substring.
 * A substring may be as small as one character.
 */
public class TwoStrings {

    private TwoStrings() {
        // Private Constructor
    }

    public static String twoStrings(String s1, String s2) {
        String output = "NO";
        Set<String> stringOneSet = new HashSet<>(Arrays.asList(s1.split(SEPARATOR)));
        Set<String> stringTwoSet = new HashSet<>(Arrays.asList(s2.split(SEPARATOR)));
        stringOneSet.retainAll(stringTwoSet);

        if (!stringOneSet.isEmpty()) {
            output = "YES";
        }

        return output;
    }


}
