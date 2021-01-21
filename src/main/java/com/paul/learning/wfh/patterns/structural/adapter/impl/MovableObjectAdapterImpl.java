package com.paul.learning.wfh.patterns.structural.adapter.impl;

import com.paul.learning.wfh.patterns.structural.adapter.MovableObject;
import com.paul.learning.wfh.patterns.structural.adapter.MovableObjectAdapter;

import java.math.BigDecimal;

/**
 * A class implementing the {@link MovableObjectAdapter}.
 */
public class MovableObjectAdapterImpl implements MovableObjectAdapter {
    private MovableObject movableObject;

    /**
     * Constructor for {@link MovableObjectAdapterImpl}.
     *
     * @param movableObject - The {@link MovableObject} to be processed.
     */
    public MovableObjectAdapterImpl(MovableObject movableObject) {
        this.movableObject = movableObject;
    }

    /**
     * Implementation of getSpeed() method.
     *
     * @return The speed.
     */
    @Override
    public BigDecimal getSpeed() {
        return convertMPHtoKMPH(movableObject.getSpeed());
    }

    /**
     * Method which converts the {@link MovableObject} speed into KM/H.
     *
     * @param mph - The speed in MP/H.
     * @return The converted speed.
     */
    private BigDecimal convertMPHtoKMPH(BigDecimal mph) {
        return mph.multiply(BigDecimal.valueOf(1.609));
    }
}
