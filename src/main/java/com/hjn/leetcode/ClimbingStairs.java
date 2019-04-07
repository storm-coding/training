package com.hjn.leetcode;

/**
 * 70. Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    /**
     * 题目意思： 你正在爬楼梯，到山顶需要n步。
     *            每次你可以爬1或2级台阶。你可以用几种不同的方式爬到山顶?
     *
     * 思路： 1、自底向上。使用一个数组存储之前的结果
     */
    public int climbStairs(int n) {
        int[] flags = new int[n+1];
        flags[0] = 1;
        flags[1] = 1;
        for (int i = 2; i <= n; i++) {
            flags[i] = flags[i-1] + flags[i-2];
        }

        return flags[n];
    }


    /**
     * 2、递归求解。使用数组保存之前计算过的结果
     */
    private int[] flags;

    public int climbStairs1(int n) {
        flags = new int[n];
        for (int i = 0; i < n; i++) {
            flags[i] = -1;
        }
        return countStairs(n);
    }

    public int countStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (flags[n-1] == -1) {
            flags[n-1] = countStairs(n - 1) + countStairs(n - 2);
        }
        return flags[n-1];
    }

    /**
     * 3、普通递归。因为存在大量重复计算。在leetcode上会超时
     */
    //time out
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(44));
    }
}
