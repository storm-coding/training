package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

import java.util.*;

/**
 * leetcode 103
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 题目意思： 给定一个二叉树，返回节点值的锯齿级的顺序遍历（从左到右，然后从右往左进行下一层，这样交换的进行）
     *
     * 思路： 思路和102类似，不过采用双向队列进行临时存储。如果是偶数层，从前放后取，反之是单数层，前取后放
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        int curLevel = 1;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ArrayDeque<TreeNode> levelQueue = new ArrayDeque<>();
            List<Integer> levelList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = null;
                if (curLevel % 2 == 0) {
                    node = queue.pollLast();
                    if (node == null) {
                        continue;
                    }
                    levelList.add(node.val);
                    if (node.right != null) {
                        levelQueue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        levelQueue.addFirst(node.left);
                    }
                } else {
                    node = queue.pollFirst();
                    if (node == null) {
                        continue;
                    }
                    levelList.add(node.val);
                    if (node.left != null) {
                        levelQueue.addLast(node.left);
                    }
                    if (node.right != null) {
                        levelQueue.addLast(node.right);
                    }
                }
            }
            curLevel++;
            if (!levelList.isEmpty()) {
                nodes.add(levelList);
            }
            queue = levelQueue;
        }

        return nodes;
    }

}
