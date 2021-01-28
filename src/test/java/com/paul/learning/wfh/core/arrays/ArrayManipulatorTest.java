package com.paul.learning.wfh.core.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ArrayManipulatorTest {

    @Test
    public void basicInput() {
        int[][] queries = {
                {5, 3},
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };
        long value = ArrayManipulator.arrayManipulation(5, queries);
        Assertions.assertEquals(200L, value);
    }

    @Test
    public void otherOneInput() {
        int[][] queries = {
                {10, 3},
                {1, 5, 3},
                {4, 8, 7},
                {6, 9, 1},
        };
        long value = ArrayManipulator.arrayManipulation(10, queries);
        Assertions.assertEquals(10L, value);

    }

    @Test
    public void otherInput() {
        int[][] queries = {
                {10, 4},
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        };
        long value = ArrayManipulator.arrayManipulation(10, queries);
        Assertions.assertEquals(31L, value);

    }
}
