package com.paul.learning.wfh.patterns.factory.impl;

import com.paul.learning.wfh.patterns.factory.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing a {@link Circle}.
 */
public class Circle implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Circle.class);
    private String type;

    /**
     * Public Constructor for {@link Circle}.
     */
    public Circle() {
        this.type = "Circle";
    }

    /**
     * Implementation of the draw method for the {@link Circle} class.
     */
    @Override
    public void draw() {
        LOGGER.info("Circle draw() method.");
    }

    @Override
    public String getType() {
        return this.type;
    }
}
