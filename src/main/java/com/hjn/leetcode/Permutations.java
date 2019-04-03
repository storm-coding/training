package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 */
public class Permutations {
    /**
     * 题目意思： 给定一个包含不同数字的集合，然会所有可能的组合
     *
     * 思路： 遍历数组，对于已遍历的数组中的元素存放在一个list中，
     *        然后递归调用未遍历的元素。这里在回溯的时候需要删除list当前元素
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> groups = new ArrayList<>();
        if (nums.length == 0) {
            return groups;
        }
        List<Integer> numsList = new ArrayList<>();
        for(int i : nums) {
            numsList.add(i);
        }
        permute(numsList, new ArrayList<Integer>(), groups);
        return groups;
    }

    private void permute(List<Integer> nums, List<Integer> list, List<List<Integer>> groups) {
        if (nums.size() == 0) {
            groups.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            list.add(nums.get(i));
            List<Integer> tmp = new ArrayList<>(nums);
            tmp.remove(i);
            permute(tmp, list, groups);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }
}
