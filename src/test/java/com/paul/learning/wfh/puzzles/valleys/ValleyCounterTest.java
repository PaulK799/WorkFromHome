package com.paul.learning.wfh.puzzles.valleys;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValleyCounterTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValleyCounterTest.class);

    @Test
    public void countValleyTest() {
        ValleyCounter valleyCounter = new ValleyCounter();
        String steps = "UDDDUDUU";
        int totalValleys = valleyCounter.countingValleys(8, steps);
        Assertions.assertEquals(1, totalValleys);
    }
}
