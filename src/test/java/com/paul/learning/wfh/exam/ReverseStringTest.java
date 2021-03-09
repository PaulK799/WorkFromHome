package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ReverseStringTest {

    ReverseString reverseString;

    @BeforeEach
    public void setup() {
        reverseString = new ReverseString();
    }

    @Test
    public void basicReverseStringTest() {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        char[] expected = {'o', 'l', 'l', 'e', 'h'};

        // Reverse Order
        reverseString.reverseString(chars);

        // Convert to Strings for equals.
        String charsString = Arrays.toString(chars);
        String expectedString = Arrays.toString(expected);

        // Compare expected with actual.
        Assertions.assertEquals(expectedString, charsString);
    }
}
