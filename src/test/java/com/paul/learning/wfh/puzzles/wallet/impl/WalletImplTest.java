package com.paul.learning.wfh.puzzles.wallet.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.LinkedList;

@SpringBootTest
public class WalletImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(WalletImpl.class);

    @Test
    public void getLoadTest() {
        WalletImpl wallet = new WalletImpl(0L, new LinkedList<>());
        wallet.load("wallet.txt");
        Collection<Long> coins = wallet.peek();
        Assertions.assertEquals(6, coins.size());
        Assertions.assertEquals(new Long(1502), wallet.getBalance());
    }

    @Test
    public void spendPartialConsumeTest() {
        WalletImpl wallet = new WalletImpl(0L, new LinkedList<>());
        wallet.load("wallet.txt");
        Collection<Long> coins = wallet.peek();
        Assertions.assertEquals(6, coins.size());
        Assertions.assertEquals(1502L, wallet.getBalance());
        spendAmount(wallet, 101L);
        Assertions.assertEquals(4, coins.size());
        Assertions.assertEquals(1401L, wallet.getBalance());
    }

    @Test
    public void spendHalfConsumeTest() {
        WalletImpl wallet = new WalletImpl(0L, new LinkedList<>());
        wallet.load("wallet.txt");
        Collection<Long> coins = wallet.peek();
        Assertions.assertEquals(6, coins.size());
        Assertions.assertEquals(1502L, wallet.getBalance());
        spendAmount(wallet, 751L);
        Assertions.assertEquals(2, coins.size());
        Assertions.assertEquals(751L, wallet.getBalance());
    }

    @Test
    public void spendFullConsumeTest() {
        WalletImpl wallet = new WalletImpl(0L, new LinkedList<>());
        wallet.load("wallet.txt");
        Collection<Long> coins = wallet.peek();
        Assertions.assertEquals(6, coins.size());
        Assertions.assertEquals(1502L, wallet.getBalance());
        spendAmount(wallet, 1502L);
        Assertions.assertEquals(0, coins.size());
        Assertions.assertEquals(0L, wallet.getBalance());
    }

    @Test()
    public void spendMoreConsumeTest() {
        WalletImpl wallet = new WalletImpl(0L, new LinkedList<>());
        wallet.load("wallet.txt");
        Collection<Long> coins = wallet.peek();
        Assertions.assertEquals(6, coins.size());
        Assertions.assertEquals(1502L, wallet.getBalance());
        IllegalAccessError exception = Assertions.assertThrows(IllegalAccessError.class, () -> {
            wallet.spend(1503L);
        });
        Assertions.assertEquals("Spend exceeds Balance", exception.getMessage());
        LOGGER.info("Exception thrown: {}", exception.getMessage());
    }

    /**
     * Spend a specific amount from the {@link WalletImpl}.
     *
     * @param wallet - the {@link WalletImpl} being processed.
     * @param amount - The {@link Long} being processed.
     */
    private void spendAmount(WalletImpl wallet, Long amount) {
        // Before
        LOGGER.info("Before Coins:{}", wallet.peek().toString());
        LOGGER.info("Before Balance:{}", wallet.getBalance());
        LOGGER.info("Spend: {}", amount);
        Long remainingAmount = wallet.spend(amount);

        // After
        LOGGER.info("Remaining Amount:{}", remainingAmount);
        LOGGER.info("After Coins:{}", wallet.peek().toString());
        LOGGER.info("After Balance:{}", wallet.getBalance());
    }
}
