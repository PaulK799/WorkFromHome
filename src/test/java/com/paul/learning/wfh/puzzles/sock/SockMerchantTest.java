package com.paul.learning.wfh.puzzles.sock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SockMerchantTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SockMerchantTest.class);

    @Test
    public void sockMerchantTest() {
        SockMerchant sockMerchant = new SockMerchant();
        int[] socks = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int totalSockPairs = sockMerchant.sockMerchant(7, socks);
        Assertions.assertEquals(3, totalSockPairs);
    }
}
