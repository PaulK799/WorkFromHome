package com.paul.learning.wfh.patterns.creational.prototype;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import static com.paul.learning.wfh.constants.GlobalConstants.SEPARATOR_COMMA;

/**
 * A class representing a {@link Position}.
 */
public class Position {
    private int x;
    private int y;

    /**
     * Public constructor for the {@link Position}.
     *
     * @param x - The {@link Position} location on the x axis.
     * @param y - The {@link Position} location on the y axis.
     */
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Position(@JsonProperty("x") int x, @JsonProperty("y") int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the {@link Position} on the x-axis.
     *
     * @return The x Position.
     */
    public int getXAxis() {
        return this.x;
    }

    /**
     * Get the {@link Position} on the y-axis.
     *
     * @return The y Position.
     */
    public int getYAxis() {
        return this.y;
    }

    /**
     * Implements object comparison
     *
     * @param obj - The {@link Object} being parsed.
     * @return A boolean indicating if equals to {@link Position}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Position that = (Position) obj;
        return Objects.equals(this.x, that.x) &&
                Objects.equals(this.y, that.y);
    }

    /**
     * Returns the hashCode for the {@link Position}.
     *
     * @return The hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    /**
     * Add implementation of toString for the {@link Position}.
     *
     * @return The constructed string.
     */
    @Override
    public String toString() {
        return "Position: {" + x + SEPARATOR_COMMA + y + "}";
    }
}
