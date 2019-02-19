package com.hjn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 454
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
 * All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 */
public class FourSumII {

    /**
     * 题目意思： 给出四个int类型的列表，计算出有多少个四元组(i, j, k, l) 使得他们的和(A[i] + B[j] + C[k] + D[l])为0
     *            让问题变简单点：A,B,C,D他们的长度在【0，500】之间，整数的范围在-2的28次方到2的28次方-1之间，他们的和做大不超过2的31次方-1
     *
     * 思路： 1、先遍历AB,将A,B的每个组合的和存在一个map中，
     *        2、遍历CD,将C、D的每个组合的和sum去对应的map中查找key为-sum的值
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> ABSum = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                ABSum.put(sum, ABSum.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = 0 - C[i] - D[j];
                if (ABSum.get(sum) != null) {
                    result += ABSum.get(sum);
                }
            }
        }
        return result;
    }
}
