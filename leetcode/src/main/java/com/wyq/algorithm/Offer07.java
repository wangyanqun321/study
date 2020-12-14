package com.wyq.algorithm;

/**
 * @author 王艳群
 * @description
 * @date 2020/10/21
 */
public class Offer07 {

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

    }

    public static BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        BinaryTreeNode binaryTreeNode = new BinaryTreeNode(3);
        binaryTreeNode.left = null;
        binaryTreeNode.right = null;
        return null;
    }

    /**
     * 前序遍历：【根左右】
     * 中序遍历：【左根右】
     * 后序遍历：【左右根】
     */
    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int x) { val = x; }
    }

}
