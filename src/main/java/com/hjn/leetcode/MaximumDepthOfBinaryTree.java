package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;

/**
 * leetcode 104. Maximum Depth of Binary Tree
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class MaximumDepthOfBinaryTree {
    /**
     * 题目意思： 给定一个树，求一个树的最大深度。最大深度是从根节点到叶节点的最长路径中的节点树
     *
     * 思路： 当前节点的最大深度等于当前节点的左右节点到最大深度+1，
     *        递归调用上述过程
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) {
            return 0;
        }
        depth = Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
        return depth;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree depth = new MaximumDepthOfBinaryTree();
        TreeNode root = BinaryTreeUtils.create(new Integer[] {3,9,20,null,null,15,7});
        System.out.println(depth.maxDepth(root));
    }
}
