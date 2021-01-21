package com.paul.learning.wfh.patterns.factory.impl;

import com.paul.learning.wfh.patterns.factory.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class representing a {@link Square}.
 */
public class Square implements Shape {

    private static final Logger LOGGER = LoggerFactory.getLogger(Square.class);
    private String type;

    /**
     * Public Constructor for {@link Square}.
     */
    public Square() {
        this.type = "Square";
    }

    /**
     * Implementation of the draw method for the {@link Square} class.
     */
    @Override
    public void draw() {
        LOGGER.info("Square draw() method.");
    }

    @Override
    public String getType() {
        return this.type;
    }
}
