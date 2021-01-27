package com.paul.learning.wfh.valleys;

/**
 * A class to solve the ValleyCounter problem.
 */
public class ValleyCounter {
    private static final String UP ="U";
    private static final String DOWN ="D";

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public int countingValleys(int steps, String path) {
        // Write your code here
        String[] hike = path.split("");

        int valleyCount = 0;
        int level = 0;
        boolean isBelowSea = false;
        for (String step : hike) {

            if (step.equals(UP)) {
                level += 1;
            }

            if (step.equals(DOWN)) {
                level -= 1;
            }

            if (isBelowSea && level == 0) {
                valleyCount += 1;
                isBelowSea = false;
            }

            if (level < 0) {
                isBelowSea = true;
            }
        }

        return valleyCount;
    }
}
