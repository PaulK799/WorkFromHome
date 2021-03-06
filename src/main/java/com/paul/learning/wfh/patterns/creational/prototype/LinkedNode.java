package com.paul.learning.wfh.patterns.creational.prototype;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.paul.learning.wfh.constants.GlobalConstants.SEPARATOR_COMMA;

/**
 * A {@link LinkedNode} implementation.
 */
public class LinkedNode extends Node {
    private AtomicInteger parentId;
    private LinkedList<AtomicInteger> childIds;

    /**
     * Instantiate the {@link Node} with an id and a starting {@link Position}.
     *
     * @param id       - The id of the {@link Node}.
     * @param parentId - The parent id of the {@link Node}.
     * @param x        - The x axis starting position of the {@link Node}.
     * @param y        - The y axis startion position of the {@link Node}.
     */
    public LinkedNode(AtomicInteger id, AtomicInteger parentId, int x, int y) {
        super(id, x, y);
        if (parentId != null) {
            this.parentId = parentId;
        }
    }

    /**
     * Get the parentId for the {@link LinkedNode}.
     *
     * @return The parentId.
     */
    public AtomicInteger getParentId() {
        return parentId;
    }

    /**
     * Get the parentId for the {@link LinkedNode}.
     *
     * @return The parentId.
     */
    public List<AtomicInteger> getChildIds() {
        if (childIds == null) {
            childIds = new LinkedList<>();
        }
        return childIds;
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
        return Objects.equals(this.getPosition().getXAxis(), that.getPosition().getXAxis()) &&
                Objects.equals(this.getPosition().getYAxis(), that.getPosition().getYAxis());
    }

    /**
     * Returns the hashCode for the {@link Node}.
     *
     * @return The hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getId(), parentId, childIds, getPosition());
    }

    /**
     * Add implementation of toString for the {@link Node}.
     *
     * @return The constructed string.
     */
    @Override
    public String toString() {
        String childIdParsed = Optional.ofNullable(childIds)
                .map(Objects::toString)
                .orElse("[]");
        return "Node: { id:" + this.getId() + SEPARATOR_COMMA + "parentId:" + this.parentId + SEPARATOR_COMMA + "childIds:" + childIdParsed + SEPARATOR_COMMA
                + "Position: {" + this.getPosition().getXAxis() + SEPARATOR_COMMA + this.getPosition().getYAxis() + "}";
    }

    /**
     * Implement the copy() method from {@link Node}.
     *
     * @param id - The Id for the copied {@link LinkedNode}.
     * @return The {@link LinkedNode}.
     */
    @Override
    public LinkedNode addNode(int id) {
        AtomicInteger atomicInteger = new AtomicInteger(id);
        this.getChildIds().add(atomicInteger);
        return new LinkedNode(atomicInteger, this.getId(),
                this.getPosition().getXAxis(), this.getPosition().getYAxis());
    }
}
