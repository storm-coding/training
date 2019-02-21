package com.hjn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode 219
 * <p>
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j
 * in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {
    /**
     * 题目意思：给出一个整形数组和一个整数k,在数组中找出是否存在i,j使得nums[i]=nums[j],并且他们的绝对值之差不超过k
     *
     * 思路1： 双重循环暴力解法，对每个遍历的当前节点，向后寻找k个数，查找是不是能找到和当前节点相等的数
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) > i) {
                continue;
            }
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
            map.put(nums[i], i + k);
        }
        return false;
    }

    /**
     * 思路2： 上面解法的优化，
     *         使用一重循环，利用一个map(可以使用set)存放之前出现过的值，遍历的时候查找map中是不是有值，并且他们的间距是不是小于k
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
