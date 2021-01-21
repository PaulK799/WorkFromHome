package com.paul.learning.wfh.patterns.structural.adapter.impl;

import com.paul.learning.wfh.patterns.structural.adapter.MovableObject;

import java.math.BigDecimal;

/**
 * A class which implements a {@link MovableObject}.
 */
public class Ball implements MovableObject {
    private BigDecimal speed;

    public Ball(BigDecimal speed) {
        this.speed = speed;
    }

    /**
     * Implementation of getSpeed() from {@link MovableObject}.
     *
     * @return The speed in MPH.
     */
    @Override
    public BigDecimal getSpeed() {
        return this.speed;
    }
}
