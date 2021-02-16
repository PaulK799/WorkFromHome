package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Test the {@link UsersAPI}.
 */
@SpringBootTest
public class UsersAPITest {

    @Test
    public void getUsersThresholdBasicTest() {
        List<String> usernames = UsersAPI.getUsernames(1);
        Assertions.assertEquals(30, usernames.size());
    }

    @Test
    public void getUsersThresholdHigherTest() {
        List<String> usernames = UsersAPI.getUsernames(10);
        Assertions.assertEquals(21, usernames.size());
    }
}
