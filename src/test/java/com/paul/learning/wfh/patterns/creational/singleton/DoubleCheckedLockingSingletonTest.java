package com.paul.learning.wfh.patterns.creational.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * A test for the {@link DoubleCheckedLockingSingleton} class.
 */
@SpringBootTest
public class DoubleCheckedLockingSingletonTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoubleCheckedLockingSingletonTest.class);

    /**
     * Test the {@link DoubleCheckedLockingSingleton} class.
     */
    @Test
    public void doubleCheckedLogingSingletonParallelTest() {
        DoubleCheckedLockingSingleton singletonOne = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton singletonTwo = DoubleCheckedLockingSingleton.getInstance();

        LOGGER.info("Init Value 1: {}, Value 2: {}", singletonOne.getValue(), singletonTwo.getValue());

        // Add Singletons to a linked list.
        List<DoubleCheckedLockingSingleton> doubleCheckedLockingSingletons = new ArrayList<>();
        doubleCheckedLockingSingletons.add(singletonOne);
        doubleCheckedLockingSingletons.add(singletonTwo);

        // Processed in parallel on a forked thread.
        doubleCheckedLockingSingletons.parallelStream().forEach(doubleCheckedLockingSingleton -> {
            LOGGER.info("Before Add Value 1: {}", doubleCheckedLockingSingleton.getValue());
            doubleCheckedLockingSingleton.setValue(doubleCheckedLockingSingleton.getValue() + 1);
            LOGGER.info("After Add Value 1: {}", doubleCheckedLockingSingleton.getValue());
        });
        Assertions.assertEquals(singletonOne.getValue(), singletonTwo.getValue());
        LOGGER.info("Init Value 1: {}, Value 2: {}", singletonOne.getValue(), singletonTwo.getValue());
    }
}
