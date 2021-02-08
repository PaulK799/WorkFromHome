package com.paul.learning.wfh.core.dictionaries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TwoStringsTest {

    @Test
    public void twoStringsBasicTest() {
        String result = TwoStrings.twoStrings("hello", "world");
        Assertions.assertEquals("YES", result);
    }

    @Test
    public void twoStringsInvalidTest() {
        String result = TwoStrings.twoStrings("hi", "world");
        Assertions.assertEquals("NO", result);
    }
}
