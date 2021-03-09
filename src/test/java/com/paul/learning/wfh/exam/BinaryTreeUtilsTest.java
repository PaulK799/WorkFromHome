package com.paul.learning.wfh.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class BinaryTreeUtilsTest {

    BinaryTreeUtils binaryTreeUtils;

    @BeforeEach
    public void setup() {
        binaryTreeUtils = new BinaryTreeUtils();
    }

    @Test
    public void complexTreeMaxDepthTest() {
        TreeNode layerTwoLeft = new TreeNode(15, null, null);
        TreeNode layerTwoRight = new TreeNode(7, null, null);
        TreeNode rootLeft = new TreeNode(9, null, null);
        TreeNode rootRight = new TreeNode(20, layerTwoLeft, layerTwoRight);
        TreeNode root = new TreeNode(3, rootLeft, rootRight);

        int layers = binaryTreeUtils.maxDepth(root);
        Assertions.assertEquals(3, layers);
    }

    @Test
    public void emptyTreeMaxDepthTest() {
        int layers = binaryTreeUtils.maxDepth(null);
        Assertions.assertEquals(0, layers);
    }

    @Test
    public void basicTreeMaxDepthTest() {
        TreeNode rootRight = new TreeNode(2);
        TreeNode root = new TreeNode(3, null, rootRight);
        int layers = binaryTreeUtils.maxDepth(root);
        Assertions.assertEquals(2, layers);
    }

    @Test
    public void singleTreeMaxDepthTest() {
        TreeNode root = new TreeNode(0);
        int layers = binaryTreeUtils.maxDepth(root);
        Assertions.assertEquals(1, layers);
    }

    @Test
    public void complexTreeMinDepthTest() {
        TreeNode layerTwoLeft = new TreeNode(15, null, null);
        TreeNode layerTwoRight = new TreeNode(7, null, null);
        TreeNode rootLeft = new TreeNode(9, null, null);
        TreeNode rootRight = new TreeNode(20, layerTwoLeft, layerTwoRight);
        TreeNode root = new TreeNode(3, rootLeft, rootRight);

        int layers = binaryTreeUtils.minDepth(root);
        Assertions.assertEquals(2, layers);
    }

    @Test
    public void emptyTreeMinDepthTest() {
        int layers = binaryTreeUtils.minDepth(null);
        Assertions.assertEquals(0, layers);
    }

    @Test
    public void basicTreeMinDepthTest() {
        TreeNode rootRight = new TreeNode(2);
        TreeNode root = new TreeNode(3, null, rootRight);
        int layers = binaryTreeUtils.minDepth(root);
        Assertions.assertEquals(1, layers);
    }

    @Test
    public void singleTreeMinDepthTest() {
        TreeNode root = new TreeNode(0);
        int layers = binaryTreeUtils.minDepth(root);
        Assertions.assertEquals(1, layers);
    }

    @Test
    public void complexLevelorder() {
        TreeNode layerTwoLeft = new TreeNode(15, null, null);
        TreeNode layerTwoRight = new TreeNode(7, null, null);
        TreeNode rootLeft = new TreeNode(9, null, null);
        TreeNode rootRight = new TreeNode(20, layerTwoLeft, layerTwoRight);
        TreeNode root = new TreeNode(3, rootLeft, rootRight);

        List<List<Integer>> expectedResultList = new ArrayList<>();
        expectedResultList.add(Collections.singletonList(3));
        expectedResultList.add(Arrays.asList(9, 20));
        expectedResultList.add(Arrays.asList(15, 7));

        List<List<Integer>> resultList = binaryTreeUtils.levelOrder(root);
        Assertions.assertTrue(Arrays.deepEquals(expectedResultList.toArray(), resultList.toArray()));
    }
}
