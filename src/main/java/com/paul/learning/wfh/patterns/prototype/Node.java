package com.paul.learning.wfh.patterns.prototype;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static com.paul.learning.wfh.constants.GlobalConstants.SEPARATOR_COMMA;

/**
 * A class representing a single {@link Node}.
 */
public abstract class Node {
    private AtomicInteger id;
    private Position position;

    /**
     * Instantiate the {@link Node} with an id and a starting {@link Position}.
     *
     * @param id - The id of the {@link Node}.
     * @param x  - The x axis starting position of the {@link Node}.
     * @param y  - The y axis startion position of the {@link Node}.
     */
    public Node(AtomicInteger id, int x, int y) {
        this.id = id;
        this.position = new Position(x, y);
    }

    /**
     * Returns the id for the {@link Node}.
     *
     * @return The id.
     */
    public AtomicInteger getId() {
        return id;
    }

    /**
     * Get the {@link Position} for the {@link Node}.
     *
     * @return The {@link Position}.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * The {@link Position} of the {@link Node}.
     *
     * @param position - The {@link Position} to be processed.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Implements object comparison
     *
     * @param obj - The {@link Object} being parsed.
     * @return A boolean indicating if equals to {@link Node}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Node that = (Node) obj;
        return Objects.equals(this.position.getXAxis(), that.position.getXAxis()) &&
                Objects.equals(this.position.getYAxis(), that.position.getYAxis());
    }

    /**
     * Returns the hashCode for the {@link Node}.
     *
     * @return The hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }

    /**
     * Add implementation of toString for the {@link Node}.
     *
     * @return The constructed string.
     */
    @Override
    public String toString() {
        return "Node: {" + id + SEPARATOR_COMMA + "Position: {"
                + position.getXAxis() + SEPARATOR_COMMA + position.getYAxis() + "}";
    }

    /**
     * Definition for a copy method for a class implementing a {@link Node}.
     *
     * @param id - The new id for the copied {@link Node}.
     * @return The copied {@link Node}.
     */
    public abstract Node addNode(int id);
}
