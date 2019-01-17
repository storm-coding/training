package com.hjn.leetcode;

/**
 * LeetCode 011
 * Given n non-negative integers a1, a2, ..., an ,where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 */
public class MostWater {
    /**
     * 题目的意思就是，给出一个数组。找出在数轴上的最大面积。
     * 思路：分别从数组的左右起点，相向靠近
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right){
            int temp = (right-left) * (height[left] - height[right] > 0 ? height[left++] : height[right--]);
            if(temp > result) {
                result = temp;
            }
        }
        return result;
    }
}
