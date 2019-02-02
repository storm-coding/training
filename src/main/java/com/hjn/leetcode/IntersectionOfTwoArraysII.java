package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 350
 * Given two arrays, write a function to compute their intersection.
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 */
public class IntersectionOfTwoArraysII {
    /**
     * 题目意思： 给定两个数组，编写一个函数计算你们的交集
     *
     * 思路： 1、和349一样，不过本题不需要去重，所有用map表示nums1每个数字出现的个数
     *        2、遍历nums2,如果当前当前数字在map1中，则放入一个list的结果集中，最后将list转换为数组
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            if (map1.get(i) == null) {
                map1.put(i, 1);
            } else {
                map1.put(i, map1.get(i) + 1);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i : nums2) {
            if ((map1.get(i) != null) && (map1.get(i) > 0)) {
                result.add(i);
                map1.put(i, map1.get(i) - 1);
            }
        }

        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }

}
