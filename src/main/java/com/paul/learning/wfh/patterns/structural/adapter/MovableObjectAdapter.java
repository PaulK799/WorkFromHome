package com.paul.learning.wfh.patterns.structural.adapter;

import java.math.BigDecimal;

/**
 * An Adapter for returning speed in KM/H.
 */
public interface MovableObjectAdapter {
    /**
     * Returns speed in KMH.
     */
    BigDecimal getSpeed();
}
