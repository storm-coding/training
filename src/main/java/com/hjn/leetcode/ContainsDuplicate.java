package com.hjn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 217
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {
    /**
     * 题目意思： 给出一个整形数组，找出数组中是否包含重复项，你如果任何数至少出现两次则返回true，如果每个元素都是不同的则返回false
     *
     * 思路：     遍历数组，将出现过的保存在set中，遍历时判断set中是否存在
     *
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> containSet = new HashSet<>();
        for (int i : nums) {
            if (containSet.contains(i)) {
                return true;
            }
            containSet.add(i);
        }
        return false;
    }
}
