package com.paul.learning.wfh.exam.ngram;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {

    /**
     * Most frequent n-gram. If &gt; 1 with same frequency, return list.
     *
     * @param value  - The {@link String} to be processed.
     * @param window - The length of the n-gram to be parsed.
     * @return The most frequent n-gram. otherwise null.
     */
    public static String ngram(String value, int window) {

        // Boundary Conditions
        if (value == null || window == 0 || value.length() < window) {
            return null;
        }

        // Store ngrams and counter for tracking.
        Map<String, Integer> ngramCounter = new HashMap<>();

        String[] characters = value.split("");
        int numOfCharacters = characters.length;

        // Used for storing the most frequent value.
        int maxCounter = Integer.MIN_VALUE;
        String firstMostFrequentNGram = null;


        // Iterate through each
        for (int index = 0; index < numOfCharacters; index++) {
            StringBuilder builder = new StringBuilder();
            builder.append(characters[index]);

            // Ensure you do not exceed the boundary of the array.
            int offsetMax = Math.min(numOfCharacters, index + window);
            for (int offsetIndex = index + 1; offsetIndex < offsetMax; offsetIndex++) {
                builder.append(characters[offsetIndex]);
            }

            String ngram = builder.toString();
            // Confirm Ngram is same length as sliding window.
            if (ngram.length() == window) {
                int counter = 1;

                // Extract from map if exists.
                if (ngramCounter.containsKey(ngram)) {
                    counter = ngramCounter.get(ngram) + 1;
                    ngramCounter.put(ngram, counter);
                }
                ngramCounter.put(ngram, counter);

                // If counter exceeds max counter, set first most frequent.
                if (counter > maxCounter) {
                    maxCounter = counter;
                    firstMostFrequentNGram = ngram;
                }
            }
        }
        return firstMostFrequentNGram;
    }
}
