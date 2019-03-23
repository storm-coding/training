package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;

/**
 * 101. Symmetric Tree
 * <p>
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree {
    /**
     * 题目意思： 给定一个二叉树，判断它是不是镜像的（即：围绕它的中心对称）
     *
     * 思路： 1、首先判断给定节点是不是为空
     *        2、递归调用节点的左孩子和右孩子是不是成镜像的
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode root = BinaryTreeUtils.create(new Integer[] {1,2,2,null,3,null,3});
        System.out.println(symmetricTree.isSymmetric(root));
    }
}
