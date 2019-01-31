package com.hjn.leetcode;

/**
 * leetCode076
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    /**
     * 题目意思： 给定一个字符串s和t， 在时间复杂度为O(N)下，找出s中最小的包含t的字串
     *            1、如果没有包含的字串，返回""
     *            2、如果存在，那么最小的字串是唯一的
     * 思路： 和题438思路类似，使用一个256的int数组保存t中每个字符出现的次数，从左往右遍历，当匹配的字串完全包含t时，利用当前最小的窗口逐渐的去比较
     */
    public String minWindow(String s, String t) {
        int[] tNums = new int[256];
        for (int i = 0; i < t.length(); i++) {
            tNums[t.charAt(i)]++;
        }

        int contains = 0;
        int left = 0;
        boolean find = false;
        // start、end 标记返回结果的字符串下标
        int start = 0;
        int end = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (tNums[s.charAt(i)] > 0) {
                contains++;
            }
            tNums[s.charAt(i)]--;

            if (contains == t.length()) {
                find = true;
                for (; left <= i; left++) {

                    if (tNums[s.charAt(left)] == 0) {
                        if ( (i - left) < (end - start) ) {
                            start = left;
                            end = i;
                            // 使用start和end标记位置，不需要每次都创建一个新的字符串对象
                            // result = s.substring(left,i+1);
                        }
                        contains--;
                        tNums[s.charAt(left)]++;
                        left++;
                        break;
                    }
                    tNums[s.charAt(left)]++;

                }
            }
        }
        return find ? s.substring(start,end+1) : "";
    }

}
