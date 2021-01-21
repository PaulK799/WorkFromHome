package com.paul.learning.wfh.patterns.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A test for the {@link ShapeFactory} class.
 */
@SpringBootTest
public class ShapeFactoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShapeFactoryTest.class);

    @Test
    public void createSquareTest() {
        createValidShape("Square");
    }

    @Test
    public void createCircleTest() {
        createValidShape("Circle");
    }

    @Test
    public void createRectangleTest() {
        createValidShape("Rectangle");
    }

    @Test
    public void createInvalidShapeTest() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("Octogon");
        Assertions.assertNull(shape);
    }

    /**
     * Method for producing and validating a shape.
     * @param type - The type of shape to be created.
     */
    protected void createValidShape(String type) {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape(type);
        Assertions.assertEquals(type, shape.getType());
        LOGGER.info("Type: {}", shape.getType());
    }
}
