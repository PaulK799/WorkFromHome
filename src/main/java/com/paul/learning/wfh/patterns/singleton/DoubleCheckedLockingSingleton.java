package com.paul.learning.wfh.patterns.singleton;

/**
 * A class prescribing the {@link DoubleCheckedLockingSingleton} based Singleton implementation.
 *
 * @author paul.kennedy
 */
public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;
    private volatile int value = 0;

    /**
     * Private constructor to avoid instantiation of {@link DoubleCheckedLockingSingleton}.
     */
    private DoubleCheckedLockingSingleton() {
    }

    /**
     * Returns the instance of the {@link DoubleCheckedLockingSingleton}.
     *
     * @return The {@link DoubleCheckedLockingSingleton} to be returned.
     */
    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton .class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    /**
     * Get the {@link DoubleCheckedLockingSingleton} value.
     *
     * @return The {@link DoubleCheckedLockingSingleton} value.
     */
    public int getValue() {
        return value;
    }

    /**
     * Set the {@link DoubleCheckedLockingSingleton} value.
     *
     * @param value - The {@link DoubleCheckedLockingSingleton} value to be processed.
     */
    public void setValue(int value) {
        this.value = value;
    }
}
