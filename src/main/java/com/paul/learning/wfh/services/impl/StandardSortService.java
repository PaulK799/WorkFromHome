package com.paul.learning.wfh.services.impl;

import com.paul.learning.wfh.services.SortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StandardSortService implements SortService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StandardSortService.class);

    /**
     * Implementation of the sort function.
     *
     * @param value - The {@link String} value to be sorted.
     * @return The sorted {@link String} using merge sort.
     */
    @Override
    public String sort(String value) {
        LOGGER.info("Unknown Sort Type, Default Sort");
        return value;
    }
}
