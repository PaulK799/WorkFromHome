package com.paul.learning.wfh.patterns.factory;

import com.paul.learning.wfh.patterns.factory.impl.Circle;
import com.paul.learning.wfh.patterns.factory.impl.Square;
import com.paul.learning.wfh.patterns.factory.impl.Rectangle;

/**
 * Factory class for the {@link Shape} interface.
 */
public class ShapeFactory {

    /**
     * Factory method for getting a {@link Shape} given its type.
     *
     * @param type - The type of the {@link Shape} to be returned.
     * @return The {@link Shape} being processed.
     */
    public Shape getShape(String type) {
        Shape shape;
        String parsedType = type.toUpperCase();
        switch (parsedType) {
            case "CIRCLE":
                shape = new Circle();
                break;
            case "SQUARE":
                shape = new Square();
                break;
            case "RECTANGLE":
                shape = new Rectangle();
                break;
            default:
                shape = null;
        }
        return shape;
    }
}
