package com.paul.learning.wfh.exam.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeUtils {

    int maxValue;

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

    /**
     * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
     * A node can only appear in the sequence at most once.
     * Note that the path does not need to pass through the root.
     *
     * The path sum of a path is the sum of the node's values in the path
     * Given the root of a {@link TreeNode}, return the maximum path sum of any path.
     *
     * @param root - The {@link TreeNode} to be processed.
     * @return The max sum path of the largest values stored.
     */
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;

        if (root == null) {
            return 0;
        }

        maxPathTraversal(root);
        return maxValue;
    }

    private int maxPathTraversal(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Get Max Path taking Left and Right values
        int left = Math.max(0, maxPathTraversal(node.left));
        int right = Math.max(0, maxPathTraversal(node.right));

        // Compute value based on combination of Left, Right and Current Value Paths.
        maxValue = Math.max(maxValue, left + right + node.val);

        // Current Node Value + Max of either Left or Right.
        return node.val + Math.max(left, right) ;
    }
}
