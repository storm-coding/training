package com.hjn.leetcode;

/**
 * Leetcode027
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {
    /**
     * 题目的意思是给定一个数组，和一个目标元素。将数组中的目标元素全部移除，
     * 然后然会新数组的长度。并且不能使用额外的空间，在o(1)的时间复杂度内完成
     *
     * 思路：题目不需要考虑数组的顺序和超出新长度数组的后面的元素，所以只需要碰到不需要移除的元素就往前移即可
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
