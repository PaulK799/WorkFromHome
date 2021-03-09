package com.paul.learning.wfh.exam.pipeline;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link FizzBuzz} class.
 */
@SpringBootTest
public class FizzBuzzTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FizzBuzzTest.class);

    @Test
    public void genericExamTest() {
        FizzBuzz.fizzBuzz(15);
    }
}
