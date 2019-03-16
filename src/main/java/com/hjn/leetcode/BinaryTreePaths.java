package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * <p>
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {
    /**
     * 题目意思： 给定一棵二叉树，返回所有从根到叶子节点的路径
     *
     * 思路： 如果当前节点是叶子节点，直接返回。否则递归求左孩子个路径和右孩子的路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        return binaryTreePaths(root, new ArrayList<>(), "");
    }

    public List<String> binaryTreePaths(TreeNode root, List<String> paths, String p) {
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            p += root.val;
            paths.add(p);
            return paths;
        }
        p += root.val + "->";
        binaryTreePaths(root.left, paths, p);
        binaryTreePaths(root.right, paths, p);
        return paths;
    }
}
