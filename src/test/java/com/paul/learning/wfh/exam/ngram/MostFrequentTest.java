package com.paul.learning.wfh.exam.ngram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MostFrequentTest {

    @Test
    public void basicMostFrequentNGram() {
        String mostFrequentNGram = MostFrequent.ngram("abcdaxe", 2);
        Assertions.assertEquals("ab", mostFrequentNGram);
    }

    @Test
    public void additionalMostFrequentNGram() {
        String mostFrequentNGram = MostFrequent.ngram("abcdaxeab", 2);
        Assertions.assertEquals("ab", mostFrequentNGram);
    }
}
