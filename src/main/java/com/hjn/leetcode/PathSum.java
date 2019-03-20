package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * 112. Path Sum
 * <p>
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 */
public class PathSum {
    /**
     * 题目意思： 给定一棵二叉树和一个数字sum。判断是不是存在从根节点到叶子节点的路径，使得这个路径上所有节点的和为sum
     *             叶子节点是没有子节点的节点
     *
     * 思路： 判断当前节点是不是叶子节点，如果是返回当前节点的值是不是等于sum，如果不是则递归调用它的左孩子和右孩子
     *                                        1
     *                                       / \
     * 因为题目说的是根节点到叶子节点，所以2  null 的 1->null  不是一条路径
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val - sum == 0;
        }
        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b");
//        list.add("c");
        list.set(3,"a");
    }
}
