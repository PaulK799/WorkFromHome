package com.paul.learning.wfh.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A test for the {@link CommonChild} class.
 */
@SpringBootTest
public class CommonChildTest {

    @Test
    public void harrySallyTest() {
        String s1 = "HARRY";
        String s2 = "SALLY";
        int longestString = CommonChild.commonChild(s1, s2);
        Assertions.assertEquals(2, longestString);
    }

    @Test
    public void zeroCommonTest() {
        String s1 = "AA";
        String s2 = "BB";
        int longestString = CommonChild.commonChild(s1, s2);
        Assertions.assertEquals(0, longestString);
    }

    @Test
    public void complexCommonTest() {
        String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";
        int longestString = CommonChild.commonChild(s1, s2);
        Assertions.assertEquals(3, longestString);
    }

    @Test
    public void simpleCommonTest() {
        String s1 = "ABCDEF";
        String s2 = "FBDAMN";
        int longestString = CommonChild.commonChild(s1, s2);
        Assertions.assertEquals(2, longestString);
    }

    @Test
    public void harrySallyRecursiveTest() {
        String s1 = "HARRY";
        String s2 = "SALLY";
        int longestString = CommonChild.commonChildRecursive(s1, s2);
        Assertions.assertEquals(2, longestString);
    }

    @Test
    public void zeroCommonRecursiveTest() {
        String s1 = "AA";
        String s2 = "BB";
        int longestString = CommonChild.commonChildRecursive(s1, s2);
        Assertions.assertEquals(0, longestString);
    }

    @Test
    public void complexCommonRecursiveTest() {
        String s1 = "SHINCHAN";
        String s2 = "NOHARAAA";
        int longestString = CommonChild.commonChildRecursive(s1, s2);
        Assertions.assertEquals(3, longestString);
    }

    @Test
    public void simpleCommonRecursiveTest() {
        String s1 = "ABCDEF";
        String s2 = "FBDAMN";
        int longestString = CommonChild.commonChildRecursive(s1, s2);
        Assertions.assertEquals(2, longestString);
    }
}
