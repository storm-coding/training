package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * <p>
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestorOfABinarySearchTree {
    /**
     * 题目意思： 给定一个二叉搜索树（BST）,给定两个bst节点，找出他们最近公共祖先
     *           根据维基百科对LCA的定义:“在两个节点p和q之间定义的最低公共祖先是T中同时
     *           具有p和q作为后代的最低节点(在这里，我们允许一个节点作为其自身的后代)。”
     *
     * 思路： 判断节点p,q是不是在当前节点的两侧，或者是等于p，q其中的一个。
     *        如果是返回当前节点，否则在p，q同一侧的节点中查找
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val) || root.val == p.val || root.val == q.val) {
            return root;
        }

        if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinarySearchTree lca = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = BinaryTreeUtils.create(new Integer[] {2,1});
        TreeNode parent = lca.lowestCommonAncestor(root,new TreeNode(1),new TreeNode(2));
        System.out.println(parent.val);
    }
}
