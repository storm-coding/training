package com.hjn.leetcode;

/**
 * leetCode209
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a contiguous subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 */
public class MinimumSizeSubarraySum {
    /**
     * 题目意思： 给定一个正数数组，和一个正数s。给出最小的连续子数组的长度，它们的和大于等s,没有的话返回0
     * <p>
     * 思路： 给定左右两个索引，分别从最左侧开始，如果当前两个索引之间的和小于s，则右索引++，反之做左索引--
     */
    public int minSubArrayLen(int s, int[] nums) {
        int right = -1;
        int left = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while (left < nums.length) {
            if (sum < s && right < nums.length - 1) {
                sum += nums[++right];
            } else {
                sum -= nums[left++];
            }

            if (sum >= s) {
                len = Math.min(len, right - left + 1);
            }
        }
        if (len == Integer.MAX_VALUE)
            return 0;
        return len;
    }
}
