package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 144
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {

    /**
     * 前序遍历：首先访问根结点然后遍历左子树，最后遍历右子树。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(root, nodes);
        return nodes;
    }

    private void traversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root.val);
        traversal(root.left, nodes);
        traversal(root.right, nodes);
    }

    /**
     * 使用栈代替递归
     */
    public List<Integer> preorderTraversal_1(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            nodes.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }

        return nodes;
    }
}
