package com.paul.learning.wfh.sort.input;

/**
 * Enumeration for the types of {@link SortType}.
 */
public enum SortType {
    MERGE("MERGE"), QUICK("QUICK"), DEFAULT("");

    private String type;

    SortType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
