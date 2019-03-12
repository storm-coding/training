package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

import java.util.*;

/**
 * leetcode 102
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    /**
     * 题目意思：层序遍历二叉树
     *
     * 思路：用队列先进先出的特点存储需要遍历的每层节点
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return null;
        }

        List<List<Integer>> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Queue<TreeNode> levelQueue = new LinkedList<>();
            List<Integer> levelList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                levelList.add(node.val);
                levelQueue.add(node.left);
                levelQueue.add(node.right);
            }
            if(!levelList.isEmpty()) {
                nodes.add(levelList);
            }
            queue = levelQueue;
        }

        return nodes;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal treeLevel = new BinaryTreeLevelOrderTraversal();

    }
}
