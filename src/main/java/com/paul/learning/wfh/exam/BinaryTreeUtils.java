package com.paul.learning.wfh.exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * Calculate the maximum depth of the {@link TreeNode}.
     *
     * @param root - The {@link TreeNode} being processed.
     * @return The max depth of the {@link TreeNode}.
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values.
     * (i.e., from left to right, level by level).
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();

        // Handle null TreeNode.
        if (root == null) {
            return resultList;
        }

        // Create a processing queue.
        Queue<TreeNode> queue = new LinkedList<>();

        // Start with the root TreeNode.
        queue.add(root);

        // While Queue has content.
        while (!queue.isEmpty()) {
            // Create List for the current layer.
            List<Integer> currentResultList = new ArrayList<>();
            int size = queue.size();

            // Process Queue for current size of the queue before processing.
            for (int i = 0; i < size; i++) {
                // Poll Queue
                TreeNode currentNode = queue.poll();
                currentResultList.add(currentNode.val);

                // Add Left Node to Queue for processing.
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add Right Node to Queue for processing.
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            // Add current level to result.
            resultList.add(currentResultList);
        }
        return resultList;
    }
}
