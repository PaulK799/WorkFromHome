package com.paul.learning.wfh.patterns.prototype;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A class for testing a {@link LinkedNode}.
 */
@SpringBootTest
public class LinkedNodeTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedNodeTest.class);

    @Test
    public void addNodeTest() {
        LinkedNode linkedNode = new LinkedNode(1, null, 0, 0);
        LOGGER.info("Original:{}", linkedNode.toString());
        LinkedNode copyNode = linkedNode.addNode(2);
        LOGGER.info("After Add:{}", linkedNode.toString());
        LOGGER.info("Added:{}", copyNode.toString());
        Assertions.assertEquals(copyNode.getParentId(), linkedNode.getId());
    }
}
