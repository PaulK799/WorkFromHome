package com.paul.learning.wfh.sort.input;

/**
 * The {@link SortInput} class.
 */
public class SortInput {
    private String value;
    private String type;

    /**
     * The value for the {@link SortInput}.
     *
     * @return The value stored in the {@link SortInput}.
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value for the SortInput;
     *
     * @param value - The value to be set for the {@link SortInput}
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * The type for the {@link SortInput}.
     *
     * @return The type stored in the {@link SortInput}.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type for the SortInput;
     *
     * @param type - The type to be set for the {@link SortInput}
     */
    public void setType(String type) {
        this.type = type;
    }
}
