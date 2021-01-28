package com.paul.learning.wfh.puzzles.wallet;

import java.util.Collection;

/**
 * Interface class for the wallet.
 */
public interface Wallet {

    /**
     * Load money into my wallet (denominations of any kind are acceptable).
     */
    void load(String filename);

    /**
     * Return current balance of my wallet
     */
    Long getBalance();

    /**
     * Return the coins in the wallet.
     * (peek does NOT need to be performant as to be used solely for testing)
     */
    Collection<Long> peek();

    /**
     * Spend an [amount] of money from Wallet and ensure the wallet is updated
     * (any change should be added back to the wallet as a single amount)
     * Return single change amount (if any change due) or zero.
     */
    Long spend(Long amount);
}
