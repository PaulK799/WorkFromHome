package com.paul.learning.wfh.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MultiplyStringTest {

    @Test
    public void multStringTestTwo() {
        int value = MultiplyString.solution(4, "two");
        Assertions.assertEquals(8, value);
    }
}
