package com.paul.learning.wfh.exam.binarytree;

import com.paul.learning.wfh.patterns.creational.builder.Person;

import java.util.Objects;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Implements object comparison
     *
     * @param obj - The {@link Object} being parsed.
     * @return A boolean indicating if equals to {@link TreeNode}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TreeNode that = (TreeNode) obj;
        return Objects.equals(this.val, that.val) &&
                Objects.equals(this.left, that.left) &&
                Objects.equals(this.right, that.right);
    }

    /**
     * Returns the hashCode for the {@link Person}.
     *
     * @return The hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.val, this.left, this.right);
    }
}
