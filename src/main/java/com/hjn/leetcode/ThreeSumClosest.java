package com.hjn.leetcode;

import java.util.*;

/**
 * leetCode 016
 * Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            throw new RuntimeException("nums length lees 3");
        }
        int targetClosest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        Set<Integer> hashCount = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            if (hashCount.contains(nums[i])) {
                continue;
            }
            hashCount.add(nums[i]);
            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                long tn = (sum - target) * (sum - target);
                long tl = (targetClosest - target) * (targetClosest - target);
                if (tn < tl) {
                    targetClosest = sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return target;
                }
            }
        }
        return targetClosest;
    }

}
