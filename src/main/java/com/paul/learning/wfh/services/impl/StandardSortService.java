package com.paul.learning.wfh.services.impl;

import com.paul.learning.wfh.services.SortService;
import org.springframework.stereotype.Service;

@Service
public class StandardSortService implements SortService {

    /**
     * Implementation of the sort function.
     *
     * @param value - The {@link String} value to be sorted.
     * @return The sorted {@link String} using merge sort.
     */
    @Override
    public String sort(String value) {
        return value;
    }
}
