package com.paul.learning.wfh.exam;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

    /**
     * Determines if the {@link String} contains valid Parentheses which are opened/closed in provided pairs.
     *
     * @param s - The {@link String} to be processed.
     * @return A boolean indicating if valid.
     */
    public boolean isValid(String s) {
        // Parentheses Pairs to be processed.
        Map<Character, Character> matchingParenthesesMap = new HashMap<>();
        matchingParenthesesMap.put('(', ')');
        matchingParenthesesMap.put('{', '}');
        matchingParenthesesMap.put('[', ']');

        ArrayDeque<Character> stack = new ArrayDeque<>();
        // Process each character in String.
        for (char character : s.toCharArray()) {
            // Check if character available in the map.
            if (matchingParenthesesMap.containsKey(character)) {
                stack.push(matchingParenthesesMap.get(character));
            } else {
                // Stack is empty or character not equal to first element in Stack.
                if (stack.isEmpty() || character != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
