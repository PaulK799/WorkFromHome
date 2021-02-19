package com.paul.learning.wfh.core.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link MarksToys} class.
 */
@SpringBootTest
public class MarksToysTest {

    @Test
    public void calculateMaxToysBasic() {
        int[] priceList = {1, 12, 5, 111, 200, 1000, 10};
        int budget = 50;
        int maxToys = MarksToys.maximumToys(priceList, budget);
        Assertions.assertEquals(4, maxToys);
    }
}
