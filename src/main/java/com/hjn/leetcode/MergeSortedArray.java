package com.hjn.leetcode;

/**
 * leetcode088
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class MergeSortedArray {
    /**
     * 题目意思：对两个已经排序的数组，合并成一个有序的数组
     * 思路： 归并排序的merge步骤
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeNums = new int[m + n];
        int length1 = 0, length2 = 0, lengthM = 0;

        while (length1 < m && length2 < n) {
            if (nums1[length1] < nums2[length2]) {
                mergeNums[length1 + length2] = nums1[length1++];
            } else {
                mergeNums[length1 + length2] = nums2[length2++];
            }
        }
        for (; length1 < m; length1++) {
            mergeNums[length1 + length2] = nums1[length1];
        }
        for (; length2 < n; length2++) {
            mergeNums[length1 + length2] = nums2[length2];
        }
        for (int i = 0; i < mergeNums.length; i++) {
            nums1[i] = mergeNums[i];
        }
    }

    /**
     * 因为本题的数组1，的长度是大于等于两数组之和的，所以这里没有必要额外开一个数组
     * 节省内存的同时，同时节省一次数组遍历的时间
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        m = m -1; n = n - 1;
        while (m >= 0 && n >= 0) {
            if(nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m--];
            } else {
                nums1[m + n + 1] = nums2[n--];
            }
        }
        // 到这里只会有一个数组中还有元素
        if ( m >= 0) {
            for (; m >= 0; m--) {
                nums1[m] = nums1[m];
            }
        } else {
            for (; n >= 0; n--) {
                nums1[n] = nums2[n];
            }
        }
    }

}
