package com.hjn.leetcode;

/**
 * leetcode080
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArrayII {
    /**
     * 26题的延申，不过这里同一个元素可以出现两次
     * 思路，除了不相等的时候可以交换，还有前面只有一个相等的时候也可以进行交换
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2 ) {
            return nums.length;
        }
        int length = 2;

        for (int i = 2; i< nums.length; i++) {
            if ( (nums[i] != nums[length - 1]) || (nums[length - 1] != nums[length - 2]) ) {
                int temp = nums[i];
                nums[i] = nums[length];
                nums[length++] = temp;
            }
        }
        return length;
    }
}
