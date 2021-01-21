package com.paul.learning.wfh.patterns.factory;

/**
 * Interface for a {@link Shape}
 */
public interface Shape {

    /**
     * Method for drawing a shape.
     */
    void draw();

    /**
     * Returns the type for the Shape.
     *
     * @return The type of the {@link Shape}.
     */
    String getType();
}
