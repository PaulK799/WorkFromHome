package com.paul.learning.wfh.core.arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringBootTest
public class NewYearsChaosTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * Captures System.out for the test.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Reverts back to standard {@link PrintStream} for System.out after test complete.
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void minBribeSimpleTest() {
        int[] array = {2, 1, 5, 3, 4};
        NewYearsChaos.minimumBribes(array);
        String[] output = outputStreamCaptor.toString().split(System.getProperty("line.separator"));
        Assertions.assertEquals("3", output[0]);
    }
}
