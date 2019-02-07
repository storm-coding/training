package com.hjn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode205
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 */
public class IsomorphicStrings {

    /**
     * 题目意思：给定两个字符串s和t，判断他们是不是同构的，如果字符串s可以通过替换得到t那么他们是同构的。
     * 所有的字符都必须替换成另一个字符并且保持字符的顺序，
     * 没有两个字符可以同时映射到同一个字符，但是可以映射到它自己
     * 思路：1、遍历字符串t，value是它对应位置的s，存入map中，如果和之前存入的不相等则返回false
     *       2、遍历map的value，如果出现重复的则返回false
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (map.get(t.charAt(i)) == null) {
                map.put(t.charAt(i), s.charAt(i));
            }else {
                if(map.get(t.charAt(i)) !=  s.charAt(i) ) {
                    return false;
                }
            }
        }
        Set<Character> set = new HashSet<>();
        for(Character c : map.values()) {
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }

        return true;
    }
}
