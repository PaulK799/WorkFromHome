package com.paul.learning.wfh.puzzles.wallet.impl;

import com.paul.learning.wfh.puzzles.wallet.Wallet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * A class implementing the {@link Wallet}
 */
public class WalletImpl implements Wallet {
    private static final Logger LOGGER = LoggerFactory.getLogger(WalletImpl.class);

    private Long balance;
    private LinkedList<Long> coins;

    public WalletImpl(Long balance, Collection<Long> coins) {
        this.balance = balance;
        this.coins = new LinkedList<>(coins);
    }

    /**
     * Load money into my wallet (denominations of any kind are acceptable).
     */
    @Override
    public void load(String filename) {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filename);
        if (inputStream != null) {
            try (Scanner scanner = new Scanner(inputStream, "UTF-8")) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] coinsList = line.split(",");
                    for (String coin : coinsList) {
                        Long convertedCoin = Long.valueOf(coin);
                        Collection<Long> coinsPeeked = peek();
                        coinsPeeked.add(convertedCoin);
                    }
                }
                // note that Scanner suppresses exceptions
                if (scanner.ioException() != null) {
                    throw scanner.ioException();
                }
                inputStream.close();
            } catch (IOException exception) {
                LOGGER.error("Exception:{0}", exception);
            }
        }

        LinkedList<Long> loadedCoins = peek();
        this.balance = recalcBalance(loadedCoins);
    }

    /**
     * Return current balance of my wallet
     */
    @Override
    public Long getBalance() {
        return balance;
    }

    /**
     * Return the coins in the wallet.
     * (peek does NOT need to be performant as to be used solely for testing)
     */
    @Override
    public LinkedList<Long> peek() {
        if (coins == null) {
            coins = new LinkedList<>();
        }
        return coins;
    }

    @Override
    public Long spend(Long amount) {
        Long changeDue = 0L;
        LinkedList<Long> collectedCoins = Optional.ofNullable(peek())
                .orElse(new LinkedList<>());

        if (amount > balance) {
            throw new IllegalAccessError("Spend exceeds Balance");
        }

        List<Integer> indexCoinsToRemove = new ArrayList<>();
        for (int i = 0; i < collectedCoins.size(); i++) {
            Long coin = collectedCoins.get(i);

            // Spend complete.
            if (amount == 0L) {
                break;
            } else if (amount < coin) {
                // Fully Consumed Coin
                changeDue = coin - amount;
                collectedCoins.set(i, changeDue);
                break;
            } else {
                // Partially Consumed coin
                amount = amount - coin;
                indexCoinsToRemove.add(i);
            }
        }

        // 2. Remove partially consumed Coins.
        if (!indexCoinsToRemove.isEmpty()) {
            indexCoinsToRemove.sort(Collections.reverseOrder());
            for (Integer index : indexCoinsToRemove) {
                collectedCoins.remove(index.intValue());
            }
        }

        // 3. Recalc Balance
        balance = recalcBalance(collectedCoins);

        return changeDue;
    }

    /**
     * Recalculate the balance based on the coins.
     *
     * @param coins - The {@link LinkedList} being parsed.
     * @return The update balance.
     */
    public Long recalcBalance(List<Long> coins) {
        Long recalcBalance = 0L;

        for (Long coin : coins) {
            recalcBalance += coin;
        }

        return recalcBalance;
    }
}
