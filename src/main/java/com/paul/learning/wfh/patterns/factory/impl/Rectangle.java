package com.paul.learning.wfh.patterns.factory.impl;

import com.paul.learning.wfh.patterns.factory.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing a {@link Rectangle}.
 */
public class Rectangle implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Rectangle.class);
    private String type;

    /**
     * Public Constructor for {@link Rectangle}.
     */
    public Rectangle() {
        this.type = "Rectangle";
    }

    /**
     * Implementation of the draw method for the {@link Rectangle} class.
     */
    @Override
    public void draw() {
        LOGGER.info("Rectangle draw() method.");
    }

    @Override
    public String getType() {
        return this.type;
    }
}
