package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link ValidParentheses} class.
 */
@SpringBootTest
public class ValidParenthesesTest {

    private ValidParentheses validParentheses;

    @BeforeEach
    public void setup() {
        validParentheses = new ValidParentheses();
    }

    @Test
    public void validString() {
        String testString = "()";
        boolean isValid = validParentheses.isValid(testString);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void validComplexString() {
        String testString = "()[]{}";
        boolean isValid = validParentheses.isValid(testString);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void invalidBasicString() {
        String testString = "(]";
        boolean isValid = validParentheses.isValid(testString);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void invalidComplexString() {
        String testString = "(]";
        boolean isValid = validParentheses.isValid(testString);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void validExtraComplexString() {
        String testString = "{[]}";
        boolean isValid = validParentheses.isValid(testString);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void validLongString() {
        String testString = "{{}[][[[]]]}";
        boolean isValid = validParentheses.isValid(testString);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void emptyString() {
        String testString = "";
        boolean isValid = validParentheses.isValid(testString);
        Assertions.assertTrue(isValid);
    }
}
