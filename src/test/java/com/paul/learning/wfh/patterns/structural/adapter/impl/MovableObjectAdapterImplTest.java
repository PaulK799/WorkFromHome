package com.paul.learning.wfh.patterns.structural.adapter.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Test the {@link MovableObjectAdapterImpl} by converting speed from MP/h into KM/H.
 */
@SpringBootTest
public class MovableObjectAdapterImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovableObjectAdapterImplTest.class);

    /**
     * Test the {@link MovableObjectAdapterImpl}.
     */
    @Test
    public void testMphToKMh() {
        Ball football = new Ball(BigDecimal.valueOf(15));
        // Convert football speed into KM/H
        MovableObjectAdapterImpl movableObjectAdapter = new MovableObjectAdapterImpl(football);
        BigDecimal footballInKMH = movableObjectAdapter.getSpeed();

        // Format to two decimal places.
        footballInKMH = footballInKMH.setScale(2, RoundingMode.HALF_UP);
        Assertions.assertEquals(24.14, footballInKMH.doubleValue());

        LOGGER.info("Speed of ball in MP/H, {}", football.getSpeed().toString());
        LOGGER.info("Speed of ball in KM/H, {}", footballInKMH.toString());
    }
}
