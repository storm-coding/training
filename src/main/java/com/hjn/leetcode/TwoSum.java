package com.hjn.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetCode001
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {
    /**
     * 题目意思： 给定一个整形数组，返回一个两个数的索引，使得他们的和为给定的目标值。
     * 可以假定只有一个答案，同一个数不能使用两次
     * 思路： 暴力解法，双重循环
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 2) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j != i && j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 思路2： 一次遍历： 使用一个map做查找集，key为数组的值，value为数组的索引，
     *         遍历的时候（i）每次判断map中是不是有target-nums[i],有则直接返回，否则添加到map中
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 2) {
            return result;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

}
