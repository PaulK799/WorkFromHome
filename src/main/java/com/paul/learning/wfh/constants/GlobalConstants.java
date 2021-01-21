package com.paul.learning.wfh.constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GlobalConstants {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalConstants.class);
    public static final String SEPARATOR_COMMA = " , ";

    /**
     * Constructor
     */
    private GlobalConstants() {
        LOGGER.error("Utility Class. Should not be instantiated!: {}", GlobalConstants.class.getName());
    }
}
