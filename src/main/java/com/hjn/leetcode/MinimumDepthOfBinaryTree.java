package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {
    /**
     * 题目意思： 给定一棵二叉树，找出它的最小深度。
     *            最小深度是从根节点到最近叶子节点的最短路径上的节点数
     * 思路： 分别递归求左右孩子的最短深度。
     *        每次递归有以下几种情况：1、是叶子节点，左右孩子均为null，返回1
     *                                2、左孩子为null，右孩子不为null，返回右孩子的的最短深度
     *                                3、左孩子不为null，右孩子为null，返回左孩子的最短深度
     *                                4、左右孩子均不为null，返回左右孩子中较短的
     */
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        if (root.right == null && root.left == null) {
            return 1;
        } else if (root.left == null) {
            depth = minDepth(root.right) + 1;
        } else if (root.right == null) {
            depth = minDepth(root.left) + 1;
        }else {
            depth = Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return depth;
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree minimumDepth = new MinimumDepthOfBinaryTree();
        TreeNode root = BinaryTreeUtils.create(new Integer[]{3, 9, 20, null, null, 15, 7});
        System.out.println(minimumDepth.minDepth(root));
    }
}
