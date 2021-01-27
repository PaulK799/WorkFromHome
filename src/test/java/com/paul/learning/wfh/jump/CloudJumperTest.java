package com.paul.learning.wfh.jump;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * A class to test {@link CloudJumper}.
 */
@SpringBootTest
public class CloudJumperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloudJumperTest.class);

    @Test
    public void jumpOnCloudTest() {
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
        int jumps = CloudJumper.jumpingOnClouds(clouds);
        Assertions.assertEquals(4, jumps);
    }

    @Test
    public void jumpOnCloudTwoTest() {
        int[] clouds = {0, 0, 0, 1, 0, 0};
        int jumps = CloudJumper.jumpingOnClouds(clouds);
        Assertions.assertEquals(3, jumps);
    }

}
