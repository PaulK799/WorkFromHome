package com.paul.learning.wfh.core.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestOutput {

    @Test
    public void testOutput() {
        System.out.println(String.format("id = %08.2f", 423.147));
    }
}
