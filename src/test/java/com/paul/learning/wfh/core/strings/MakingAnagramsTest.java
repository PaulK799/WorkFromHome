package com.paul.learning.wfh.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Given two strings, a and b, that may or may not be of the same length,
 * determine the minimum number of character deletions required to make a and b anagrams.
 * Any characters can be deleted from either of the strings.
 */
@SpringBootTest
public class MakingAnagramsTest {

    @Test
    public void makeAnagramSimpleTest() {
        int deletions = MakingAnagrams.makeAnagram("cde", "abc");
        Assertions.assertEquals(4, deletions);
    }

    @Test
    public void makeAnagramComplexTest() {
        int deletions = MakingAnagrams.makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
        Assertions.assertEquals(30, deletions);
    }
}
