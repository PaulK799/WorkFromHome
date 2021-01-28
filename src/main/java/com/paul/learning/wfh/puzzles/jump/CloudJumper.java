package com.paul.learning.wfh.puzzles.jump;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * There is a new mobile game that starts with consecutively numbered clouds.
 * Some of the clouds are thunderheads and others are cumulus.
 * The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
 * The player must avoid the thunderheads.
 * Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud.
 * It is always possible to win the game.
 * For each game, you will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 */
public class CloudJumper {
    private static final Logger LOGGER = LoggerFactory.getLogger(CloudJumper.class);

    /**
     * Method which calculates the number of jumps to avoid Thunder Cloud.
     * {0, 0, 1, 0, 0, 1, 0}
     *
     * @param clouds - An array of clouds.
     * @return The minimum number of jumps required.
     */
    static int jumpingOnClouds(int[] clouds) {
        int totalClouds = clouds.length - 1;
        return jumpCloud(clouds, totalClouds, 0, 0);
    }

    private static int jumpCloud(int[] clouds, int endpoint, int position, int totalJumps) {
        if (position >= endpoint) {
            return totalJumps;
        }

        boolean canMoveOne = canMove(clouds, position, 1);
        boolean canMoveTwo = canMove(clouds, position, 2);

        if (canMoveOne && !canMoveTwo) {
            return jumpCloud(clouds, endpoint, position + 1, totalJumps + 1);
        } else if (canMoveTwo) {
            return jumpCloud(clouds, endpoint, position + 2, totalJumps + 1);
        }

        return totalJumps;
    }

    /**
     * A boolean indicating if given the current position is a move possible.
     *
     * @param clouds   - The cloud path to be processed.
     * @param position - Current position in puzzle.
     * @param move     - The move to be attempted.
     * @return A boolean indicating if move is possible.
     */
    static boolean canMove(int[] clouds, int position, int move) {
        if (position + move < clouds.length - 1) {
            int cloudValue = clouds[position + move];
            if (cloudValue > 0) {
                return false;
            }
        }
        return true;
    }

}
