package com.paul.learning.wfh.mvc.sort.services;

/**
 * Interface for performing Sorting algorithms.
 */
public interface SortService {

    /**
     * Method for sorting a {@link String}.
     *
     * @param value - The {@link String} value to be sorted.
     * @return The sorted {@link String}.
     */
    public String sort(String value);
}
