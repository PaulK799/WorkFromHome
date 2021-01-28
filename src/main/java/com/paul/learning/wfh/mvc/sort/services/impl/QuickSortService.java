package com.paul.learning.wfh.mvc.sort.services.impl;

import com.paul.learning.wfh.mvc.sort.services.SortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * A class for implementing merge sort.
 */
@Service
public class QuickSortService implements SortService {
    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSortService.class);

    /**
     * Implementation of the sort function.
     *
     * @param value - The {@link String} value to be sorted.
     * @return The sorted {@link String} using merge sort.
     */
    @Override
    public String sort(String value) {
        LOGGER.info("Starting Quick Sort");
        return value;
    }
}
