package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;

import javax.swing.plaf.TreeUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * leetcode 094
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {

    /**
     * 树的中序遍历： 左子树、根结点、右子树
     *
     * 思路：递归解法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        traversal(root, nodes);
        return nodes;
    }

    private void traversal(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        traversal(root.left, nodes);
        nodes.add(root.val);
        traversal(root.right, nodes);
    }

    /**
     * 栈实现的遍历
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> nodes = new ArrayList<>();
        Stack<Object> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()){
            Object obj = stack.pop();
            if(obj == null){
                continue;
            }
            if(obj instanceof TreeNode) {
                stack.push(((TreeNode) obj).right);
                stack.push(((TreeNode) obj).val);
                stack.push(((TreeNode) obj).left);
            }else {
                nodes.add((Integer) obj);
            }
        }
        return nodes;
    }

}
