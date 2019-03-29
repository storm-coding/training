package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 98. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinarySearchTree {
    /**
     * 题目意思： 给定一棵二叉树判断它是不是一棵有效的二叉查找树
     *            二叉查找树的定义如下：
     *            它的左孩子节点值只能包含小于该节点的值
     *            它的右孩子节点值只能包含小大该节点的值
     *            它的左右孩子也是一棵二叉查找树
     *
     * 思路： 这是我最开始的思路分别存下该节点的左右孩子，然后分别遍历左右孩子节点，看是不是都大于左孩子小于右孩子
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,new HashSet<>());
    }

    public boolean isValidBST(TreeNode root, Set<Integer> childNodes) {
        // 空也是二叉树
        if (root == null) {
            return true;
        }
        Set<Integer> leftChild = new HashSet<>();
        Set<Integer> rightChild = new HashSet<>();
        if(root.left !=null) {
            leftChild.add(root.left.val);
        }
        if(root.right !=null) {
            rightChild.add(root.right.val);
        }
        boolean isBST =  isValidBST(root.right,rightChild) && isValidBST(root.left,leftChild);
        for(int val:leftChild){
            if(root.val <= val) {
                return false;
            }
        }
        for(int val:rightChild){
            if(root.val >= val) {
                return false;
            }
        }
        childNodes.addAll(leftChild);
        childNodes.addAll(rightChild);
        return isBST;
    }

    /**
     * 在上面的解法当中，其实是没有必要所有的孩子节点的。其实只需要存下当前节点的取值范围即可，
     * 这也是参考leetcode代码才知道的，下面的示例代码，就直接拿过来了
     */
    public boolean isValidBST1(TreeNode root) {
        return isValid(root,null,null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max){
        if(root == null)
            return true;
        if(min != null && root.val <= min)
            return false;
        if(max != null && root.val >= max)
            return false;
        return (isValid(root.left,min,root.val) && isValid(root.right,root.val,max));
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree validate = new ValidateBinarySearchTree();
        TreeNode root = BinaryTreeUtils.create(new Integer[] {2,1,3});
        System.out.println(validate.isValidBST(root));
    }
}
