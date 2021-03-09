package com.paul.learning.wfh.exam.pipeline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class ParkingDilemma {

    /**
     *
     */
    private ParkingDilemma() {
        // Private Constructor.
    }

    /**
     * Gets the minimum length of the car parking roof.
     *
     * @param cars - A {@link List} of {@link Long} representing car positions.
     * @param k    - The minimum number of cars to be covered.
     * @return The minimum length of the roof to cover k cars.
     */
    public static long carParkingRoof(List<Long> cars, int k) {
        long minimumRoofLength = Integer.MAX_VALUE;

        // Check for empty or 0 roofs.
        if (cars.isEmpty() || k < 0) {
            return 0L;
        }

        List<Long> sortedCars = new ArrayList<>(cars);

        // Sort cars.
        Collections.sort(sortedCars);

        // Offset k relative to the array index.
        int offset = k - 1;

        for (int index = 0; index < sortedCars.size(); index++) {

            // Break condition to ensure processing.
            if (index > offset) {
                break;
            }

            // Find the target index which is index + offset. Min to ensure you do not exceed the bounds of the array.
            int targetIndex = Math.min(index + offset, sortedCars.size() - 1);

            // Start Position of the car.
            long startValue = sortedCars.get(index);
            // End position relative to the offset
            long targetValue = sortedCars.get(targetIndex);

            // If the number of cars between the start and target is great than or equal to K.
            if (targetIndex - index >= offset) {
                // Distance = (end - start) + 1 to account for the current position itself
                long distance = (targetValue - startValue) + 1;
                // Check if minimum value.
                minimumRoofLength = Math.min(distance, minimumRoofLength);
            }

        }

        return minimumRoofLength;
    }
}
