package com.paul.learning.wfh.exam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JHUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JHUtils.class);

    /**
     * Private constructor for {@link JHUtils}.
     */
    private JHUtils() {
        throw new IllegalArgumentException("Not allowed to invoke JHUtils class.");
    }

    /**
     * Explained understanding Recursion for the following thread:
     * https://www.reddit.com/r/javahelp/comments/n69ysb/can_somebody_help_me_understand_recursion_i/
     *
     * @param num - The starting number to be output.
     */
    public static void stars(int num) {

        if (num == 1) {
            return;
        }

        stars(num - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("*");
        }
        LOGGER.info(sb.toString());
    }
}
