package com.paul.learning.wfh.core.dictionaries;

import com.paul.learning.wfh.core.arrays.NewYearsChaos;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SpringBootTest
public class RandsomNoteTest {
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
    public void randsomNotePositive() {
        RandsomNote.checkMagazine(new String[]{"give me one grand today night"}, new String[]{"give one grand today"});
        String[] output = outputStreamCaptor.toString().split(System.getProperty("line.separator"));
        Assertions.assertEquals("Yes", output[0]);
    }

    @Test
    public void randsomNoteNegative() {
        RandsomNote.checkMagazine(new String[]{"two times three is not four"}, new String[]{"two times two is four"});
        String[] output = outputStreamCaptor.toString().split(System.getProperty("line.separator"));
        Assertions.assertEquals("No", output[0]);
    }
}
