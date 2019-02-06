package com.hjn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * leetcode290
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 */
public class WordPattern {

    /**
     * 题目意思： 给出一个字符串pattern和str，查找str是不是和pattern的模式一样，
     *            这里的follow表示完全匹配，这样就有一个双射在pattern和str的非空单词之间
     * 思路： 1、先遍历str分割的数组，将这个的记录存在对应的map中，结果对应一个模式字符串
     *        2、遍历pattern，将其转换成和str模式相同的字符串
     */
    public boolean wordPattern(String pattern, String str) {
        String[] strArr = str.split(" ");
        if (pattern.length() != strArr.length) {
            return false;
        }

        Map<String,Character> mapStr = new HashMap<>();
        Character start = 'a';
        String valueStr = "";

        for(String s : strArr) {
            if (mapStr.get(s) == null) {
                mapStr.put(s, start);
                valueStr += start++;
            } else {
                valueStr += mapStr.get(s);
            }
        }

        Map<Character,Character> mapPattern = new HashMap<>();
        start = 'a';
        String valuePattern = "";
        for(int i = 0; i < pattern.length(); i++) {
            if (mapPattern.get(pattern.charAt(i)) == null) {
                mapPattern.put(pattern.charAt(i), start);
                valuePattern += start++;
            } else {
                valuePattern += mapPattern.get(pattern.charAt(i));
            }
        }
        return valueStr.equals(valuePattern);
    }

    /**
     * 思路2、不需要pattern，在遍历str的同时对pattern进行判断即可（参考leetcode）
     */
    public boolean wordPattern1(String pattern, String string) {
        char[] patt = pattern.toCharArray();
        String[] str = string.split(" ");
        if (str.length != patt.length) return false;
        String[] table = new String[26];
        for (int i = 0; i < str.length; i++) {
            if (table[patt[i] - 'a'] == null) {
                table[patt[i] - 'a'] = str[i];
            } else {
                if (!str[i].equals(table[patt[i] - 'a'])) {
                    return false;
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        for (String temp : table) {
            if (temp != null) {
                if (set.contains(temp)) {
                    return false;
                } else {
                    set.add(temp);
                }
            }
        }
        return true;
    }
}
