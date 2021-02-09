package com.paul.learning.wfh.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link AlternativeCharacters} class.
 */
@SpringBootTest
public class AlternativeCharactersTest {

    @Test
    public void altCharsBasicTest() {
        int count = AlternativeCharacters.alternatingCharacters("AAAA");
        Assertions.assertEquals(3, count);
    }

    @Test
    public void altCharsBasicBTest() {
        int count = AlternativeCharacters.alternatingCharacters("BBBBB");
        Assertions.assertEquals(4, count);
    }

    @Test
    public void altCharsAltTest() {
        int count = AlternativeCharacters.alternatingCharacters("ABABABAB");
        Assertions.assertEquals(0, count);
    }

    @Test
    public void altCharsAltBTest() {
        int count = AlternativeCharacters.alternatingCharacters("BABABA");
        Assertions.assertEquals(0, count);
    }

    @Test
    public void altCharLongTest() {
        int count = AlternativeCharacters.alternatingCharacters("AAABBB");
        Assertions.assertEquals(4, count);
    }
}
