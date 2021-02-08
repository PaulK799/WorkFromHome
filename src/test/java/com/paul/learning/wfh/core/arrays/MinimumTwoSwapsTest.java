package com.paul.learning.wfh.core.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link MinimumTwoSwaps} class.
 */
@SpringBootTest
public class MinimumTwoSwapsTest {

    @Test
    public void minSwapsBasicTest() {
        int[] array = {4, 3, 1, 2};
        int swaps = MinimumTwoSwaps.minimumSwaps(array);
        Assertions.assertEquals(3, swaps);
    }

    @Test
    public void minSwapsComplexTest() {
        int[] array = {1, 3, 5, 2, 4, 6, 7};
        int swaps = MinimumTwoSwaps.minimumSwaps(array);
        Assertions.assertEquals(3, swaps);
    }
}
