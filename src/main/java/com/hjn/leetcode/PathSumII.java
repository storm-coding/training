package com.hjn.leetcode;

import com.hjn.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 * <p>
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSumII {
    /**
     *题目意思： 给定一棵二叉树和一个数sum，找出所有从根到叶子节点的路径，使得每条路径上的数的和等于sum
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return pathSum(root, new ArrayList<>(),new ArrayList<>(),sum);
    }

    public List<List<Integer>> pathSum(TreeNode root,List<List<Integer>> paths, List<Integer> pNum, int sum) {
        List<Integer> p = new ArrayList<>(pNum);
        if(root == null) {
            return paths;
        }
        p.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            paths.add(p);
            return paths;
        }
        pathSum(root.left,paths,p,sum - root.val);
        pathSum(root.right,paths,p,sum - root.val);
        return paths;
    }
}
