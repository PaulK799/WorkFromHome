package com.paul.learning.wfh.patterns.singleton;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Singleton class defined using Enum to ensure serialization and thread-safety guaranteed.
 */
public enum EnumSingleton {
    INSTANCE(new AtomicInteger(0));
    private AtomicInteger value;

    /**
     * Private constructor for {@link EnumSingleton}.
     *
     * @param value - The {@link AtomicInteger}.
     */
    private EnumSingleton(AtomicInteger value) {
        this.value = value;
    }

    /**
     * Returns the instance of {@link EnumSingleton}.
     *
     * @return The {@link EnumSingleton} being processed.
     */
    public EnumSingleton getInstance() {
        return INSTANCE;
    }

    /**
     * Get the {@link EnumSingleton} value.
     *
     * @return The {@link EnumSingleton} value.
     */
    public AtomicInteger getValue() {
        return value;
    }
}
