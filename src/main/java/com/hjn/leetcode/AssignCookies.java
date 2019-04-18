package com.hjn.leetcode;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 */
public class AssignCookies {
    /**
     * 题目意思：假定你是一个极好的父亲，想给你的孩子一些饼干。但是你最多只能一个孩子一块饼干。
     *           每个孩子有一个贪心指数gi，这是孩子满意的最小饼干大小。
     *           每个饼干有一个大小的指数sj，如果sj>=gi,我们可以吧这个饼干j给孩子i，孩子就会开心。
     *           你的目标是让最多的孩子开心。输出能让做多孩子开心的数量
     *
     * 思路： 贪心的思路，对两个数组分别排序。然后从最大的饼干和最贪心的孩子开始。
     *        如果最大的饼干能满足最贪心的孩子则结果加一。反之跳过当前最贪心的孩子
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        int result = 0;
        int i = s.length - 1, j = g.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[i] >= g[j]) {
                result++;
                i--;
                j--;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AssignCookies ac = new AssignCookies();
        System.out.println(ac.findContentChildren(new int[]{1, 2}, new int[]{1,2,3}));
    }
}
