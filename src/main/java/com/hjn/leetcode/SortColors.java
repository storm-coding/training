package com.hjn.leetcode;

/**
 * Leetcode075
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
* Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {
    /**
     * 题目的意思是要将一个只有0，1，2的数组进行排序
     * 思路：分别用left、right表示0和2的边界。遍历数组如果是0则和left下标的元素进行交换，2则和right的元素进行交换
     */
    public static void sortColors(int[] nums) {
        int index = 0;
        int left = 0;

        int right = nums.length - 1;
        while (index <= right){
            if(nums[index] == 0){
                int temp = nums[index];
                nums[index] = nums[left];
                nums[left++] = temp;
                index++;
            }else if(nums[index] == 2){
                int temp = nums[right];
                nums[right--] = nums[index];
                nums[index] = temp;
            }else{
                index++;
            }
        }
    }

}
