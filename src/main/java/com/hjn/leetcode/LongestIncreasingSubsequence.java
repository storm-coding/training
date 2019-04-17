package com.hjn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 300. Longest Increasing Subsequence
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 */
public class LongestIncreasingSubsequence {
    /**
     * 题目意思： 给定一个不排序的整数数组，找出最长的递增子序列的长度
     *
     * 思路： 自底向上，每次求出i:nums[0-i]的最长子序列。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] ans = new int[nums.length];
        for(int i = 0 ;i< nums.length; i++){
            ans[i] = 1;
        }
        int res = 1;
        // 每次循环找出nums[0-i]的最长子序列
        for(int i = 1; i< nums.length; i++){
            for(int j = 0 ; j < i; j++){
                if(nums[j] < nums[i]){
                    ans[i] = Math.max(ans[j]+1, ans[i]);
                    res = Math.max(ans[i],res);
                }
            }
        }
        return res;
    }

    // 未测试
//    Map<String, Integer> ans = new HashMap<>();
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        return lengthOfLIS(nums, nums[0], 0);
//    }
//
//    public int lengthOfLIS(int[] nums, Integer pre, int index) {
//        if (index == nums.length-1) {
//            return 1;
//        }
//
//        // ans[index][pre] 表示 nums[index,nums.length) 且前缀为pre
//        String key = index + "-" + pre;
//        if (ans.get(key) != null) {
//            return ans.get(key);
//        }
//        int r1 = lengthOfLIS(nums, nums[index], index + 1);
//        int r2 = lengthOfLIS(nums, pre, index + 1);
//
//        if (nums[index] > pre || (index == 0) && nums[index] > pre) {
//            r2 = Math.max(1 + lengthOfLIS(nums, nums[index], index + 1), r2);
//        }
//        int tmp = Math.max(r1, r2);
//        ans.put(key, tmp);
//        return tmp;
//    }


    /**
     * 递归求解
     *     Time Limit Exceeded
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return lengthOfLIS1(nums, nums[0], 1, 1);
    }

    public int lengthOfLIS1(int[] nums, Integer pre, int index, int len) {
        if (index == nums.length) {
            return len;
        }
        int r1 = lengthOfLIS1(nums, nums[index], index + 1, 1);
        int r2 = lengthOfLIS1(nums, pre, index + 1, len);

        if (nums[index] > pre) {
            r2 = Math.max(lengthOfLIS1(nums, nums[index], index + 1, len + 1), r2);
        }
        return Math.max(r1, r2);
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lts = new LongestIncreasingSubsequence();
        System.out.println(lts.lengthOfLIS(new int[]{4,10,4,3,8,9}));
    }
}
