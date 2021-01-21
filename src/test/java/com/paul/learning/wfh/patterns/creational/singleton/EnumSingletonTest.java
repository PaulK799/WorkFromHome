package com.paul.learning.wfh.patterns.creational.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A test for the {@link EnumSingleton} class.
 */
@SpringBootTest
public class EnumSingletonTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EnumSingletonTest.class);

    /**
     * Test the {@link EnumSingleton} class.
     */
    @Test
    public void enumSingletonParallelAdditionTest() {
        EnumSingleton singletonOne = EnumSingleton.INSTANCE.getInstance();
        EnumSingleton singletonTwo = EnumSingleton.INSTANCE.getInstance();

        LOGGER.info("Init Value 1: {}, Value 2: {}", singletonOne.getValue(), singletonTwo.getValue());

        // Add Singletons to a linked list.
        List<EnumSingleton> enumSingletons = new ArrayList<>();
        enumSingletons.add(singletonOne);
        enumSingletons.add(singletonTwo);

        // Processed in parallel on a forked thread.
        enumSingletons.parallelStream().forEach(enumSingleton -> {
            AtomicInteger value = enumSingleton.getValue();
            LOGGER.info("Before Add Value 1: {}", enumSingleton.getValue());
            value.getAndAdd(1);
            LOGGER.info("After Add Value 1: {}", enumSingleton.getValue());
        });
        Assertions.assertEquals(singletonOne.getValue(), singletonTwo.getValue());
    }
}
