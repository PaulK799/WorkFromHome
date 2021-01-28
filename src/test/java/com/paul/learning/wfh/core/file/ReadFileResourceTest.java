package com.paul.learning.wfh.core.file;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * A class to test {@link ReadFileResource}.
 */
@SpringBootTest
public class ReadFileResourceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadFileResource.class);

    @Test
    public void readFileTest() {
        ReadFileResource readFileResource = new ReadFileResource();
        List<String> lines = readFileResource.readFile("wallet.txt");
        Assertions.assertEquals(1, lines.size());

        LOGGER.info("Size: {}", lines.size());
        LOGGER.info("Lines: {}", lines);
    }
}
