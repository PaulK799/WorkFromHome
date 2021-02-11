package com.paul.learning.wfh.exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class FizzBuzz {
    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzz.class);

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    /**
     *
     */
    private FizzBuzz() {
        // Private Constructor.
    }

    /**
     * Iterate through each integer from 1..n. Prints one value per line.
     * i is a multiple of 3 and 5. Output: FizzBuzz.
     * i is a multiple of 3 (but not 5). Output Fizz.
     * i is a multiple of 5 (but not 3). Output Buzz.
     * i is not a multiple of 3 or 5. Output value of i.
     *
     * @param n - The integer to be processed.
     */
    public static void fizzBuzz(int n) {
        // Write your code here
        for (int value = 1; value < n + 1; value++) {

            boolean isFizz = isMultiple(value, 3);
            boolean isBuzz = isMultiple(value, 5);

            if (isFizz && isBuzz) {
                // The value (i) is a multiple of 3 & 5.
                System.out.println(FIZZBUZZ);
            } else if (!isFizz && isBuzz) {
                // The value (i) is a multiple of 5 (and not 3)
                System.out.println(BUZZ);
            } else if (isFizz && !isBuzz) {
                // The value (i) is a multiple of 3 (and not 5)
                System.out.println(FIZZ);
            } else {
                System.out.println(value);
            }
        }
    }

    /**
     * Indicates if the given value is a multiple.
     *
     * @param value    - The value being processed.
     * @param multiple - The multiple to be processed.
     * @return A boolean indicating if the value is a multiple.
     */
    protected static boolean isMultiple(int value, int multiple) {
        return value % multiple == 0;
    }
}
