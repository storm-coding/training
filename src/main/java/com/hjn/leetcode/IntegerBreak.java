package com.hjn.leetcode;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * 343. Integer Break
 * Given a positive integer n, break it into the sum of at
 * least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 */
public class IntegerBreak {
    /**
     * 题目意思： 给定一个正整数，将它分解成至少两个数的和，获取这些数的乘积，返回其中的最大值。
     *
     * 思路： 要求n的最大值，就需要求n-1的最大值，依次递推至1.
     *        这里从1开始向上递推
     */
    int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] ans = new int[n+1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                ans[i] = Math.max(ans[i], Math.max(j * (i-j), j * ans[i - j ]));
            }
        }
        return ans[n];
    }


    /**
     * 方法2： 要求n的最大值，就需要求n-1的最大值，依次递推至1.
     *         递归求解，在求解的过程中使用一个数组记录下来，避免重复计算
     */
    int integerBreak1(int n) {
        int[] ans = new int[n];
        integerBreak1(n, ans);
        return ans[n - 1];
    }

    int integerBreak1(int n, int[] ans) {
        if (ans[n - 1] != 0) {
            return ans[n - 1];
        }
        int p = 1;
        for (int i = 1; i < n; i++) {
            p = Math.max(p, Math.max(i * (n - i), i * integerBreak1(n - i, ans)));
        }
        ans[n - 1] = p;
        return p;
    }

    /**
     * 方法3： 简单的递归，存在大量的重复计算。leetcode：Time Limit Exceeded
     */
    int integerBreak2(int n) {
        if (n == 1) {
            return 1;
        }
        int p = 1;
        for (int i = 1; i < n; i++) {
            p = Math.max(p, Math.max(i * (n - i), i * integerBreak2(n - i)));
        }
        return p;
    }

    public static void main(String[] args) {
        IntegerBreak ib = new IntegerBreak();
        System.out.println(ib.integerBreak(10));
    }
}
