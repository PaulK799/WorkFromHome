package com.paul.learning.wfh.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepeatedStringTest {

    @Test
    public void repeatedStringLargeTest() {
        long repeatedString = RepeatString.repeatedString("a", 1000000000000L);
        Assertions.assertEquals(1000000000000L, repeatedString);
    }

    @Test
    public void repeatedStringTest() {
        long repeatedString = RepeatString.repeatedString("aba", 10L);
        Assertions.assertEquals(7L, repeatedString);
    }
}
