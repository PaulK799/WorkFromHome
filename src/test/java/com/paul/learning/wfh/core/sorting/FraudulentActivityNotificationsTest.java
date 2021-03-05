package com.paul.learning.wfh.core.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link FraudulentActivityNotifications} class given basic input.
 */
@SpringBootTest
public class FraudulentActivityNotificationsTest {

    @Test
    public void basicNotificationsTest() {
        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};
        int notifications = FraudulentActivityNotifications.activityNotifications(expenditure, 5);
        Assertions.assertEquals(2, notifications);
    }

    @Test
    public void noNotificationsTest() {
        int[] expenditure = {1, 2, 3, 4, 4};
        int notifications = FraudulentActivityNotifications.activityNotifications(expenditure, 4);
        Assertions.assertEquals(0, notifications);
    }

    @Test
    public void simpleNotificationsTest() {
        int[] expenditure = {10, 20, 30, 40, 50};
        int notifications = FraudulentActivityNotifications.activityNotifications(expenditure, 3);
        Assertions.assertEquals(1, notifications);
    }
}
