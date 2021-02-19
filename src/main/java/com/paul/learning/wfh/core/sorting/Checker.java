package com.paul.learning.wfh.core.sorting;

import java.util.Comparator;

public class Checker implements Comparator<Player> {

    /**
     * Implementation of {@link Comparator} for the {@link Player} class.
     *
     * @param a - Player "a" to be compared.
     * @param b - Player "b" to be compared to.
     * @return An integer representing (-1 = a &lt; b), (0 = a == b), (1 = a &gt; b)
     */
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score) {
            return b.score - a.score;
        }
        return a.name.compareTo(b.name);
    }
}

/**
 * A class representing a player
 */
class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}