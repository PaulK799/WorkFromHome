package com.paul.learning.wfh.core.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * Test the {@link LeftRotation} functionality for rotating an array by a certain number of places.
 */
@SpringBootTest
public class LeftRotationTest {

    /**
     * Validates the rotation is performed correctly when a valid array and number is submitted.
     */
    @Test
    public void leftRotationValidTest() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expectedRotatedArray = {5, 1, 2, 3, 4};

        array = LeftRotation.rotLeft(array, 4);

        Assertions.assertTrue(Arrays.equals(expectedRotatedArray, array));
    }

    /**
     * Validates the rotation is performed correctly when a valid array and zero rotation is submitted.
     */
    @Test
    public void leftRotationZeroTest() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expectedRotatedArray = {1, 2, 3, 4, 5};

        array = LeftRotation.rotLeft(array, 0);

        Assertions.assertTrue(Arrays.equals(expectedRotatedArray, array));
    }

    /**
     * Validates the rotation is performed correctly when a valid array and minus rotation is submitted.
     */
    @Test
    public void leftRotationMinusTest() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expectedRotatedArray = {1, 2, 3, 4, 5};

        array = LeftRotation.rotLeft(array, -1);

        Assertions.assertTrue(Arrays.equals(expectedRotatedArray, array));
    }

    /**
     * Validates the rotation is performed correctly when a null array and valid rotation is submitted.
     */
    @Test
    public void leftRotationNullArrayTest() {
        int[] array = null;

        array = LeftRotation.rotLeft(array, 4);

        Assertions.assertNull(array, "Provided array is null.");
    }
}
