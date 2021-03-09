package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MaxDepthBinaryTreeTest {

    MaxDepthBinaryTree maxDepthBinaryTree;

    @BeforeEach
    public void setup() {
        maxDepthBinaryTree = new MaxDepthBinaryTree();
    }

    @Test
    public void complexTreeTest() {
        TreeNode layerTwoLeft = new TreeNode(15, null, null);
        TreeNode layerTwoRight = new TreeNode(7, null, null);
        TreeNode rootLeft = new TreeNode(9, null, null);
        TreeNode rootRight = new TreeNode(20, layerTwoLeft, layerTwoRight);
        TreeNode root = new TreeNode(3, rootLeft, rootRight);

        int layers = maxDepthBinaryTree.maxDepth(root);
        Assertions.assertEquals(3, layers);
    }

    @Test
    public void emptyTreeTest() {
        int layers = maxDepthBinaryTree.maxDepth(null);
        Assertions.assertEquals(0, layers);
    }

    @Test
    public void basicTreeTest() {
        TreeNode rootRight = new TreeNode(2);
        TreeNode root = new TreeNode(3, null, rootRight);
        int layers = maxDepthBinaryTree.maxDepth(root);
        Assertions.assertEquals(2, layers);
    }

    @Test
    public void singleTreeTest() {
        TreeNode root = new TreeNode(0);
        int layers = maxDepthBinaryTree.maxDepth(root);
        Assertions.assertEquals(1, layers);
    }
}
