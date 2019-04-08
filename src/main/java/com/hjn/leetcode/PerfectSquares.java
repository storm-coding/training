package com.hjn.leetcode;

import java.util.*;

/**
 * leetcode 279
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 */
public class PerfectSquares {
    /**
     * 题目意思：给定一个正整数n,找出最少的完全平方数的和等于n
     * <p>
     * 思路：暴力解法，依次求出0-n之间所有数的最小的平方数
     */
    public int numSquares(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (Math.sqrt(i) % 1 == 0) {
                ans[i] = 1;
                continue;
            }
            int temp = Integer.MAX_VALUE;
            for (int j = 1; i - j * j > 0; j++) {
                temp = Math.min(ans[i - j * j] + 1, temp);
            }
            ans[i] = temp;
        }
        return ans[n];
    }

    /**
     * 思路2： 使用广度优先的思路： 将当前节点减去一个完全平方数构成的集合放入一个队列中，然后依次遍历当前层的节点
     */
    public int numSquares1(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int result = 0;

        while (!queue.isEmpty()) {
            result++;
            Queue<Integer> tmp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 1; i <= cur; i++) {

                    if (cur - i * i == 0) {
                        return result;
                    } else if (cur - i * i > 0) {
                        tmp.add(cur - i * i);
                    } else {
                        tmp.add(cur);
                        break;
                    }
                }
            }
            queue = tmp;
        }
        return 0;
    }

    /**
     * 主要对上面的优化，主要是，每一层可能存在多个相同的数字，这里使用一个byte数组来进行去重
     */
    public int numSquares2(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int result = 0;

        while (!queue.isEmpty()) {
            result++;
            Queue<Integer> tmp = new LinkedList<>();
            // 使用hashSet时间提速也不明显
//            Set<Integer> existNumSet = new HashSet<>();
            // 使用byte数组记录，存在的数组
            byte[] existNums = new byte[n + 1];
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 1; i <= cur; i++) {
                    int sqe = i * i;
                    int sub = cur - sqe;
                    if (sub == 0) {
                        return result;
                    } else if (sub > 0) {
                        // 开始优化这样写的，但是在leetcode上会Time Limit。
                        // 原因：contains会遍历整个链表
//                        if(!tmp.contains(cur -sqe)) {
//                        if(!existNumSet.contains(sub)) {
                        if (existNums[sub] == 0) {
                            tmp.add(sub);
                            existNums[sub] = 1;
                        }
                    } else {
                        if (existNums[cur] == 0) {
                            tmp.add(cur);
                            existNums[cur] = 1;
                        }
                        break;
                    }
                }
            }
            queue = tmp;
        }
        return 0;
    }

    /**
     * 自底向上，依次求解1-n的最优解
     */
    public int numSquares3(int n) {
        int[] ans = new int[n + 1];
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int p = j*j;
                if (i < p) {
                    break;
                }
                if (i == p) {
                    ans[i] = 1;
                    continue;
                }
                if (ans[i] == 0) {
                    ans[i] = ans[i - p] + 1;
                } else {
                    ans[i] = Math.min(ans[i], ans[i - p] + 1);
                }
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {
        PerfectSquares squares = new PerfectSquares();
        System.out.println(squares.numSquares3(13));
    }
}
