package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 145
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostorderTraversal {
    /**
     * 后序遍历
     *
     * 递归实现
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(root, nodes);
        return nodes;
    }

    private void traversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        traversal(root.left, nodes);
        traversal(root.right, nodes);
        nodes.add(root.val);
    }

    /**
     * 栈实现
     */
    public List<Integer> postorderTraversal_1(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Stack stack = new Stack();
        stack.push(root);
        while (!stack.empty()){
            Object obj = stack.pop();
            if(obj == null) {
                continue;
            }
            if(obj instanceof TreeNode) {
                stack.push(((TreeNode) obj).val);
                stack.push(((TreeNode) obj).right);
                stack.push(((TreeNode) obj).left);
            }else {
                nodes.add((Integer) obj);
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal postorderTraversal = new BinaryTreePostorderTraversal();
        TreeNode root = BinaryTreeUtils.create(new Integer[] {1,null,2,3});
        System.out.println(postorderTraversal.postorderTraversal_1(root));
    }
}
