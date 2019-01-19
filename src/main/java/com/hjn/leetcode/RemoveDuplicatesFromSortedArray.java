package com.hjn.leetcode;

import com.sun.deploy.net.proxy.RemoveCommentReader;

/**
 * LeetCode026
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * 题目的意思是给定一个已经排序好的数组，每个元素只能出现一次，在空间复杂度为O(1)的情况下完成
     *
     * 思路：length当前数组中有多少个不一致的元素，
     * 遍历数组如果有如果当前元素和nums[length-1]不相等，则进行交换
     */
    public static int removeDuplicates(int[] nums) {
        if ((nums.length == 1) || (nums.length == 0)) {
            return nums.length;
        }
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[length - 1]) {
                int temp = nums[i];
                nums[i] = nums[length];
                nums[length++] = temp;
            }
        }
        return length;
    }

}
