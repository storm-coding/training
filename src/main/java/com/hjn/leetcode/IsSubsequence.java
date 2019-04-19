package com.hjn.leetcode;

/**
 * 392. Is Subsequence
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the
 * original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters.
 */
public class IsSubsequence {
    /**
     * 题目意思： 给定一个字符串s和一个字符串t，判断s是不是t的字串。
     * 你可以假定s和t都只包含小写英文字符串。t是一个长字符串长度在(500000)左右，s是一个短字符串（<100）
     * 一个字串是由原始的字串删除一些字符（可以是none）所得到。不影响其他字符的相对位置
     *
     * 思路： 贪心思想。遍历字符串s、t。如果当前的字符串s的当前元素能匹配。则s和t都向后移动。否则t向后移
     */
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        return sIndex == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence subsequence = new IsSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc"));
    }
}
