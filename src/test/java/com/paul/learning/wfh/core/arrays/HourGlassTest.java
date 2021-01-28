package com.paul.learning.wfh.core.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HourGlassTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(HourGlassTest.class);

    @Test
    public void getHourglassSumTest() {
        int[][] array = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        int sum = HourGlass.hourglassSum(array);
        Assertions.assertEquals(19, sum);
    }

    @Test
    public void getHourglassNegativeSumTest() {
        int[][] array = {
                {-1, -1, 0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };


        int sum = HourGlass.hourglassSum(array);
        Assertions.assertEquals(-6, sum);
    }
}
