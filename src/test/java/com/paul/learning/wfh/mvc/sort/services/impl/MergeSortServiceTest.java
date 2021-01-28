package com.paul.learning.wfh.mvc.sort.services.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for the {@link MergeSortService}.
 */
@SpringBootTest
public class MergeSortServiceTest {

    @InjectMocks
    private MergeSortService mergeSortService;

    /**
     * Test the {@link MergeSortService} to verify the algorithm sorts the {@link String} as expected.
     */
    @Test
    public void testMergeSortPositive() {
        String input = "516234";
        String expected = "123456";
        String actual = mergeSortService.sort(input);
        Assertions.assertEquals(expected, actual);
    }

    /**
     * Test the {@link MergeSortService} to verify the algorithm sorts the {@link String} as expected.
     */
    @Test
    public void testMergeSortAlreadySorted() {
        String input = "123456";
        String expected = "123456";
        String actual = mergeSortService.sort(input);
        Assertions.assertEquals(expected, actual);
    }
}
