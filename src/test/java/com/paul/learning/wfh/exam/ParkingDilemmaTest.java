package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test the {@link ParkingDilemma}.
 */
@SpringBootTest
public class ParkingDilemmaTest {

    @Test
    public void carParkingRoofBasicTest() {
        List<Long> cars = new ArrayList<>(Arrays.asList(2L, 10L, 8L, 17L));
        long value = ParkingDilemma.carParkingRoof(cars, 3);
        Assertions.assertEquals(9L, value);
    }

    @Test
    public void carParkingRoofTest() {
        List<Long> cars = new ArrayList<>(Arrays.asList(1L, 2L, 3L, 10L));
        long value = ParkingDilemma.carParkingRoof(cars, 4);
        Assertions.assertEquals(10L, value);
    }


}
