package com.hjn.leetcode;

import java.util.TreeSet;

/**
 * 220. Contains Duplicate III
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the absolute difference between nums[i]
 * and nums[j] is at most t and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateIII {
    /**
     * 题目意思：给定一个整数数组，找出是否存在两个不同下标i和j，
     *           使得nums[i]和nums[j]查的绝对值不超过t,i和j的范围不超过k
     *
     * 思路：  思路：这题刚开始也觉得使用查找表的方式去做，但是这题的查找表是个范围，之前并没有想到可以使用treeSet来实现。
     *               在jdk中的treeSet有api是对范围查找的，treeSet未平衡二叉搜索树实现，查找数组未lgn。所以总的时间复杂度为O(nlgn)
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
        for (int i = 0; i < nums.length; i++) {
            if(i > k){
                treeSet.remove((long)nums[i-k-1]);
            }
            Long n = treeSet.ceiling((long)nums[i]- (long)t);
            treeSet.add((long)nums[i]);
            if(n != null && n <= (long)nums[i]+(long)t){
                return true;
            }
        }
        return false;
    }

    /**
     * 双重循环，暴力解法
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                for (int j = i - 1; j >= 0; j--) {
                    // 整数溢出
                    if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                        return true;
                    }
                }
                right++;
            } else {
                for (int j = i - 1; j >= left; j--) {
                    if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
                        return true;
                    }
                }
                left++;
                right++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII duplicateIII = new ContainsDuplicateIII();
        System.out.println(duplicateIII.containsNearbyAlmostDuplicate(new int[]{0,2147483647}, 1,2147483647));
    }


}

