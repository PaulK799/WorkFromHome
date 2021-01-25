package com.paul.learning.wfh.floodfill;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Test the {@link FloodFill} class.
 */
@SpringBootTest
public class FloodFillTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FloodFillTest.class);

    /**
     * Test the {@link FloodFill} algorithm.
     */
    @Test
    public void floodFill3By3Test() {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        int[][] expectedimage = {
                {2, 2, 2},
                {2, 4, 0},
                {2, 0, 1}
        };

        FloodFill floodFill = new FloodFill(image);
        LOGGER.info("Before: {}", floodFill.toString());
        image = floodFill.fill(1, 1, 1, 2);
        LOGGER.info("After: {}", floodFill.toString());
        Assertions.assertTrue(Arrays.deepEquals(expectedimage, image));
    }

    /**
     * Test the {@link FloodFill} algorithm.
     */
    @Test
    public void floodFill7By7Test() {
        int[][] image = {
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1}
        };

        int[][] expectedimage = {
                {1, 1, 1, 0, 2, 2, 2},
                {1, 1, 1, 0, 2, 2, 2},
                {1, 1, 0, 2, 2, 2, 2},
                {0, 0, 2, 4, 2, 0, 0},
                {2, 2, 2, 2, 0, 1, 1},
                {2, 2, 2, 0, 1, 1, 1},
                {2, 2, 2, 0, 1, 1, 1}
        };

        FloodFill floodFill = new FloodFill(image);
        LOGGER.info("Before: {}", floodFill.toString());
        image = floodFill.fill(3, 3, 1, 2);
        LOGGER.info("After: {}", floodFill.toString());
        Assertions.assertTrue(Arrays.deepEquals(expectedimage, image));

    }
}
