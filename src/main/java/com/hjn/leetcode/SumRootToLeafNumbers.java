package com.hjn.leetcode;

import com.hjn.leetcode.utils.BinaryTreeUtils;
import com.hjn.leetcode.utils.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * <p>
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 */
public class SumRootToLeafNumbers {
    /**
     * 题目意思： 给定一棵二叉树，只包含0-9的数字，每个从根节点到叶子节点的一个路径都可以表示成一个数组
     *             比如，一个从根到叶子节点的路径为1->2->3,它表示的数字就是123
     *             找出所有这样子数的和。
     * 思路： 如果当前节点是叶子节点，则直接返回。否则递归求解左孩子和右孩子的和然后相加
     */
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0, 0);
    }
    // sum 为int test case 没有出现越界
    public int sumNumbers(TreeNode root, int sum, int tmp) {
        if (root == null) {
            return sum;
        }
        if (root.right == null && root.left == null) {
            sum += root.val + tmp * 10;
            return sum;
        }
        tmp = tmp * 10 + root.val;
        sum += sumNumbers(root.left, 0, tmp);
        sum += sumNumbers(root.right, 0, tmp);

        return sum;
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers leafNumbers = new SumRootToLeafNumbers();
        TreeNode root = BinaryTreeUtils.create(new Integer[] {4,9,0,5,1});
        System.out.println(leafNumbers.sumNumbers(root));
    }
}
