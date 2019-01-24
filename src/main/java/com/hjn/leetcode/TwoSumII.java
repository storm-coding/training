package com.hjn.leetcode;

/**
 * leetCode 167
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 */
public class TwoSumII {
    /**
     *  题目意思： 对一个有序数组，找出两个数的和等于给定目标值
     *
     *  思路：分别从最左和最右开始，向中间靠拢,如果小于左索引右移，反之右索引左移
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        index[0]=1;
        index[1]=numbers.length;
        for(int i=0;i<numbers.length;i++){
            if(numbers[index[0]-1]+numbers[index[1]-1]>target){
                index[1]--;
            }else if(numbers[index[0]-1]+numbers[index[1]-1]<target){
                index[0]++;
            }else {
                break;
            }
        }

        return index;
    }
}
