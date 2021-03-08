package com.paul.learning.wfh.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link SpecialStringsAgain} problem.
 */
@SpringBootTest
public class SpecialStringsAgainTest {

    @Test
    public void specialStringAgainBasicTest() {
        long actual = SpecialStringsAgain.substrCount(5, "asasd");
        Assertions.assertEquals(7L, actual);
    }

    @Test
    public void specialStringAgainBasicRepeatTest() {
        long actual = SpecialStringsAgain.substrCount(4, "aaaa");
        Assertions.assertEquals(10L, actual);
    }

    @Test
    public void specialStringAgainBasicBruteForceTest() {
        long actual = SpecialStringsAgain.substrCountBruteForce(5, "asasd");
        Assertions.assertEquals(7L, actual);
    }

    @Test
    public void specialStringAgainBasicRepeatBruteForceTest() {
        long actual = SpecialStringsAgain.substrCountBruteForce(4, "aaaa");
        Assertions.assertEquals(10L, actual);
    }

    @Test
    public void isAllStringsSameValidTest() {
        boolean isValid = SpecialStringsAgain.isAllCharsSame("aaa");
        Assertions.assertTrue(isValid);
    }

    @Test
    public void isAllStringsSameInvalidTest() {
        boolean isValid = SpecialStringsAgain.isAllCharsSame("aba");
        Assertions.assertFalse(isValid);
    }

    @Test
    public void isAllStringsPivotSameInvalidTest() {
        boolean isValid = SpecialStringsAgain.isAllCharsPivotMiddleSame("aac");
        Assertions.assertFalse(isValid);
    }

    @Test
    public void isAllStringsPivotSameValidTest() {
        boolean isValid = SpecialStringsAgain.isAllCharsPivotMiddleSame("aba");
        Assertions.assertTrue(isValid);
    }
}
