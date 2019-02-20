package com.hjn.leetcode;

import java.util.*;

/**
 * leetcode 049
 * Given an array of strings, group anagrams together.
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    /**
     * 题目意思：  给出一个字符串数组，将由相同字符组成的字符串进行分组
     *             所有的字符都是小写字符
     *             输出的顺序没关系
     * 思路：  遍历字符串，先将字符串进行排序，然后将排序的字符串在map中进行查找，如果有添加，无创建list在添加
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for (String s : strs) {
            char[] cArr = s.toCharArray();
            Arrays.sort(cArr);
            String sSort = Arrays.toString(cArr);
            if (groupMap.get(sSort) == null) {
                List<String> l = new ArrayList<>();
                l.add(s);
                groupMap.put(sSort, l);
            } else {
                groupMap.get(sSort).add(s);
            }
        }
        return new ArrayList<List<String>>(groupMap.values());
    }

}
