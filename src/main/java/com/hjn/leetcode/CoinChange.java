package com.hjn.leetcode;

/**
 * 322. Coin Change
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 */
public class CoinChange {

    /**
     * 题目意思： 给定一些不同面值的硬币和一个总金钱额amount。
     *            编写一个函数计算用最少数量的硬币使得他们可以组成amount
     *            如果amount不能由任意的硬币来组成那么然会-1.
     *
     * 思路：01背包问题，依次从[0-amount]，依次求出最小的集合
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] ans = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            ans[i] = -1;
        }
        ans[0] = 0;
        // 求在coins中能组成i的最小个数
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] == i) {
                    ans[i] = 1;
                } else if (coins[j] < i) {
                    int dis = i - coins[j];
                    if (ans[dis] != -1) {
                        int tmp = ans[dis] + 1;
                        ans[i] = ans[i] != -1 ? Math.min(tmp, ans[i]) : tmp;
                    }
                }

            }
        }
        return ans[amount];
    }


    /**
     * Time Limit Exceeded
     * 下面两种是递归求解，这题使用数组存储之前计算的结果也会发生超时
     */
    int[][] ans;
    public int coinChange1(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        ans = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                ans[i][j] = -1;
            }
        }
        return coinChange1(coins, amount, 0);
    }

    // [index,length) 之间的元素最小个数达到amount
    public int coinChange1(int[] coins, int amount, int index) {
        if (index == coins.length || amount < 0) {
            return -1;
        }
        if (ans[index][amount] != -1) {
            return ans[index][amount];
        }

        int r1 = -1;
        if (amount == coins[index]) {
            r1 = 1;
        } else {
            int tmp = coinChange1(coins, amount - coins[index], index);
            if (tmp != -1) {
                r1 = tmp + 1;
            }
        }
        int r2 = coinChange1(coins, amount, index + 1);
        int res;
        if (r1 == -1) {
            res = r2;
        } else if (r2 == -1) {
            res = r1;
        } else {
            res = Math.min(r1, r2);
        }
        ans[index][amount] = res;
        return res;
    }

    public int coinChange2(int[] coins, int amount) {
        if (amount < 0 || coins.length == 0) {
            return -1;
        }
        return coinChange2(coins, amount, 0, 0);
    }
    public int coinChange2(int[] coins, int amount, int index, int len) {
        if (index == coins.length || amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return len;
        }

        int r1 = coinChange2(coins, amount - coins[index], index, len + 1);
        int r2 = coinChange2(coins, amount, index + 1, len);
        if (r1 == -1) {
            return r2;
        }
        if (r2 == -1) {
            return r1;
        }
        return Math.min(r1, r2);
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{1, 2, 5}, 11));
    }
}
