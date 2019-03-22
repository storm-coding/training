package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

/**
 * leetcode 100. Same Tree
 * <p>
 * Given two binary trees, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    /**
     * 题目意思： 给定两棵二叉树，编写一个函数，判断他们是否相同。
     *            两棵树如果他们的结构和相同位置的值相同，那么这两棵二叉树就是相同的
     * 思路：首先判断树的节点进行判空。然后递归判断他们的左子树和右子树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}
