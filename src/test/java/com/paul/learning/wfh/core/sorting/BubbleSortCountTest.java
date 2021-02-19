package com.paul.learning.wfh.core.sorting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BubbleSortCountTest {

    @Test
    public void bubbleSortCountTest() {
        int[] array = {3, 2 ,1};
        BubbleSortCount.countSwaps(array);
    }
}
