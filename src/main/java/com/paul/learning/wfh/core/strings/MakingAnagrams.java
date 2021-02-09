package com.paul.learning.wfh.core.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.paul.learning.wfh.constants.GlobalConstants.SEPARATOR;

/**
 * Given two strings, a and b, that may or may not be of the same length,
 * determine the minimum number of character deletions required to make a and b anagrams.
 * Any characters can be deleted from either of the strings.
 */
public class MakingAnagrams {

    private MakingAnagrams() {
        // Private Constructor
    }

    /**
     * Minimum number of character deletions required to make two strings an anagram of each other.
     *
     * @param a - A {@link String} to be processed.
     * @param b - A {@link String} to be processed.
     * @return The minimum number of character deletions required to make an anagram.
     */
    public static int makeAnagram(String a, String b) {
        int deletions = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : a.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                deletions += 1;
            }
        }

        for (int value : map.values()) {
            deletions += Math.abs(value);
        }

        return deletions;
    }
}

