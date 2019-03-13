package com.hjn.leetcode;

import com.hjn.leetcode.utils.ListNode;
import com.hjn.leetcode.utils.TreeNode;

import java.util.*;

/**
 * leetcode 107
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalII {
    /**
     * 题目意思：给定一个二叉树，返回节点自低向上的顺序结果
     * 思路： 同102，最后将结果反转一下即可
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            if(!levelList.isEmpty()){
                nodes.add(levelList);
            }
            queue = levelQueue;
        }


        Collections.reverse(nodes);
        return nodes;
    }
}
