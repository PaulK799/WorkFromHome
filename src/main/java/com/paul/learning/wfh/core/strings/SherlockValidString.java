package com.paul.learning.wfh.core.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times.
 * It is also valid if he can remove just 1 character at 1 index in the string,
 * and the remaining characters will occur the same number of times.
 * Given a string , determine if it is valid.
 * If so, return YES, otherwise return NO.
 */
public class SherlockValidString {

    private SherlockValidString() {
        // Private Constructor.
    }

    /**
     * Determine if String is valid based on Sherlock algorithm.
     *
     * @param s - The {@link String} to be processed.
     * @return Statement outlining if {@link String} is valid.
     */
    static String isValid(String s) {
        String output = "NO";
        Map<String, Integer> characterCount = new HashMap<>();

        // Get the count of all characters in the String.
        String[] arr = s.split("");

        // Special character being the first character in the String.
        String specialCharacter = arr[0];

        // Get a count of all character occurances from the 1..n (excluding the special character).
        for (int i = 1; i < arr.length; i++) {
            String character = arr[i];
            if (characterCount.containsKey(character)) {
                Integer counter = characterCount.get(character);
                characterCount.put(character, counter + 1);
            } else {
                characterCount.put(character, 1);
            }
        }

        // (Maximum Logic Processing)
        // Clone the Map for processing.
        Map<String, Integer> characterCountProcess = new HashMap<>(characterCount);
        // Add the Special Character into the Map.
        if (characterCountProcess.containsKey(specialCharacter)) {
            int count = characterCountProcess.get(specialCharacter);
            characterCountProcess.put(specialCharacter, count + 1);
        } else {
            characterCountProcess.put(specialCharacter, 1);
        }

        // Calculate the Max value and Key for Max Value.
        int max = Collections.max(characterCountProcess.values());
        List<String> maxkeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : characterCountProcess.entrySet()) {
            if (entry.getValue() == max) {
                maxkeys.add(entry.getKey());
            }
        }

        // Extract the first max value key from the Map.
        Optional<String> maxkeyOpt = maxkeys.stream().findFirst();
        if (maxkeyOpt.isPresent()) {
            String key = maxkeyOpt.get();

            // Decrease the count for the max array by one.
            int counter = characterCountProcess.get(key);
            characterCountProcess.put(key, counter - 1);


            // Get a single instance of each value available.
            Set<Integer> values = new HashSet<>(characterCountProcess.values());
            // If 1 (or less) return YES. Assume when 1 value and removed that isValid.
            if (values.size() <= 1) {
                return "YES";
            }
        }

        // (Minimum Logic Processing)
        // Clone the Map for processing
        characterCountProcess = new HashMap<>(characterCount);
        // Add the Special Character into the Map.
        if (characterCountProcess.containsKey(specialCharacter)) {
            int count = characterCountProcess.get(specialCharacter);
            characterCountProcess.put(specialCharacter, count + 1);
        } else {
            characterCountProcess.put(specialCharacter, 1);
        }

        // Calculate the Min value and Key for Min Value.
        int min = Collections.min(characterCountProcess.values());
        List<String> minKeys = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : characterCountProcess.entrySet()) {
            if (entry.getValue() == min) {
                minKeys.add(entry.getKey());
            }
        }

        // Extract the first min value key from the Map.
        Optional<String> minKeyOpt = minKeys.stream().findFirst();
        if (minKeyOpt.isPresent()) {
            String key = minKeyOpt.get();
            characterCountProcess.remove(key);

            // Get a single instance of each value available.
            Set<Integer> values = new HashSet<>(characterCountProcess.values());
            // If 1 (or less) return YES. Assume when 1 value and removed that isValid.
            if (values.size() <= 1) {
                return "YES";
            }
        }

        return output;
    }
}
