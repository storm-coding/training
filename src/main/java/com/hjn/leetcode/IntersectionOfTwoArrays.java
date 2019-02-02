package com.hjn.leetcode;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode349
 * Given two arrays, write a function to compute their intersection.
 */
public class IntersectionOfTwoArrays {
    /**
     * 题目意思： 给定两个数组，编写一个函数计算他们的交集
     *
     * 思路： 1、先将nums的数组用一个set存储用于去重，然后遍历nums2，
     *        2、判断当前元素是不是在set1当中，结果也用一个set进行保存，然后将结果的set转成数组
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i : nums1) {
            set1.add(i);
        }
        Set<Integer> result = new HashSet<>();
        for(int i : nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }
        int[] resultArr = new int[result.size()];
        int index = 0;
        for(int i: result) {
            resultArr[index] = i;
            index ++;
        }
        return resultArr;
    }
}
