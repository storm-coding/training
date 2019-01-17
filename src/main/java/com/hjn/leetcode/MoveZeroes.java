package com.hjn.leetcode;

/**
 * Leetcode283
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int index = -1;

        for(int i=0;i<nums.length;i++){

            if(nums[i]!=0){
                index++;
                if(index!=i) {
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
