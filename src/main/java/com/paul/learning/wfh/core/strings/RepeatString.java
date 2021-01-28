package com.paul.learning.wfh.core.strings;

public class RepeatString {

    public static long repeatedString(String string, long n) {
        String[] values = string.split("");
        long length = values.length;
        //  Number of full {@link String} contained in infinite String.
        long numberOfFullStrings = n / length;
        // Remainder length of String in final set.
        long rem = n % length;

        // Count of all the full Strings.
        long fullStringCount = (repeatedStringCounter(values, length) * numberOfFullStrings);
        // Count of partial string.
        long partialStringCount = repeatedStringCounter(values, rem);
        return fullStringCount + partialStringCount;
    }

    /**
     * A method for counting the number of occurrences of "a" in String.
     *
     * @param string - The String to be processed.
     * @param end    - The end of the string.
     * @return The number of occurances of "a".
     */
    public static long repeatedStringCounter(String[] string, long end) {
        long count = 0L;
        for (int i = 0; i < end; i++) {
            String value = string[i];
            if (value.equals("a")) {
                count++;
            }
        }
        return count;
    }
}
