package com.hjn.leetcode;

import java.util.*;

/**
 * leetcode 018
 * Given an array nums of n integers and an integer target, are there elements a, b, c,
 * and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 */
public class FourSum {
    /**
     * 题目意思：给出一个int类型的数组和一个整数target，找出数组a、b、c、d，使得他们的和等于target
     *           找出数组里所有这样唯一的四个整数，使得他们的和为target
     *
     * 思路：同3Sum
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        Set<Integer> hashCountJ = new HashSet();
        for (int j = 0; j < nums.length - 2; j++) {
            if (hashCountJ.contains(nums[j])) {
                continue;
            }
            hashCountJ.add(nums[j]);

            Set<Integer> hashCountI = new HashSet();
            for (int i = j + 1; i < nums.length - 1; i++) {
                if (hashCountI.contains(nums[i])) {
                    continue;
                }
                hashCountI.add(nums[i]);
                int left = i + 1, right = nums.length - 1;

                Set<Integer> sl = new HashSet<>();
                Set<Integer> sr = new HashSet<>();
                while (left < right) {
                    if (nums[j] + nums[i] + nums[left] + nums[right] == target) {
                        if (sl.contains(nums[left])) {
                            left++;
                            continue;
                        }
                        if (sl.contains(nums[right])) {
                            right--;
                            continue;
                        }
                        sl.add(nums[left]);
                        sr.add(nums[right]);

                        List<Integer> l = new ArrayList();
                        l.add(nums[j]);
                        l.add(nums[i]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        result.add(l);
                        left++;
                        right--;
                    } else {
                        if (nums[j] + nums[i] + nums[left] + nums[right] > target) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
        }
        return result;
    }
}
