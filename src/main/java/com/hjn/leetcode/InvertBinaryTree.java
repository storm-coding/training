package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

/**
 * 226. Invert Binary Tree
 * Invert a binary tree.
 */
public class InvertBinaryTree {
    /**
     * 题目意思： 反转一棵二叉树
     * 思路： 先反转左子树，后反转右子树。然后分别赋值
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
