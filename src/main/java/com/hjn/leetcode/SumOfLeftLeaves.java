package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

/**
 * 404  Sum of Left Leaves
 * Find the sum of all left leaves in a given binary tree.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return sumOfLeftLeaves(root.left,0) + sumOfLeftLeaves(root.right,1);
    }

    /**
     * child 只有0，1两个值，0表示是父节点的左孩子，1表示是父节点的右孩子
     */
    public int sumOfLeftLeaves(TreeNode root, int child) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null && child == 0) {
            return root.val;
        }

        return sumOfLeftLeaves(root.left,0) + sumOfLeftLeaves(root.right,1);
    }
}
