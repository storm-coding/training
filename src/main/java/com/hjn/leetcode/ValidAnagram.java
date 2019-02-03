package com.hjn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 242
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 */
public class ValidAnagram {
    /**
     * 题目意思： 给定两个字符串s、t,编写一个函数判断t是不是可以由s变换之后得到
     *
     * 思路： 1、遍历字符串s，用一个map存储s对应每个字符出现的个数，
     *        2、遍历字符串t，map中对应t中字符减一
     *        3、遍历maps，如果maps中的value不为0，则返回false
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> maps = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (maps.get(s.charAt(i)) == null) {
                maps.put(s.charAt(i),1);
            } else {
                maps.put(s.charAt(i),maps.get(s.charAt(i)) + 1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            if (maps.get(t.charAt(i)) == null) {
                return false;
            } else {
                maps.put(t.charAt(i),maps.get(t.charAt(i)) - 1);
            }
        }

        for(int key : maps.values()) {
            if (key != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 思路2: 思路和1一样，不过使用一个int类型的256数组表示字符串s中每个字符的出现次数
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] sNums = new int[256];
        for(int i = 0; i < s.length(); i++) {
            sNums[s.charAt(i)]++;
        }

        for(int i = 0; i < t.length(); i++) {
            sNums[t.charAt(i)]--;
            if (sNums[t.charAt(i)] < 0) {
                return false;
            }
        }

        for (int nums : sNums) {
            if (nums != 0) {
                return false;
            }
        }

        return true;
    }
}
