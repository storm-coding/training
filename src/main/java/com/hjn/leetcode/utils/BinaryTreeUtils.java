package com.hjn.leetcode.utils;

import java.util.*;

/**
 * 二叉树相关工具类
 */
public class BinaryTreeUtils {
    public static TreeNode create(Integer[] nums) {
        List<Integer> nodes = new ArrayList(Arrays.asList(nums));
        if (nodes.isEmpty()) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes.remove(0));
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            parent.left = setTreeValue(nodes,parent.left,queue);
            parent.right = setTreeValue(nodes,parent.right,queue);
        }

        return root;
    }

    public static TreeNode setTreeValue(List<Integer> nodes, TreeNode tree,Queue<TreeNode> queue) {
        if (nodes.size() > 0) {
            Integer val = nodes.remove(0);
            if (val != null) {
                tree = new TreeNode(val);
                queue.add(tree);
            }
        }
        return tree;
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node!=null){
                System.out.println(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2,null, 3, 4, 5};
        print(create(nums));
    }

}
