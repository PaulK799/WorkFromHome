package com.paul.learning.wfh.exam;

public class BinaryTreeUtils {

    /**
     * Calculate the maximum depth of the {@link TreeNode}.
     *
     * @param root - The {@link TreeNode} being processed.
     * @return The max depth of the {@link TreeNode}.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
