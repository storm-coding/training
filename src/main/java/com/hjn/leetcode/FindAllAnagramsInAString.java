package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetCode438
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 */
public class FindAllAnagramsInAString {

    /**
     * 题目意思： 给出一个字符串s，和一个非空字符串p，在s中找出所有包含p的字串(这里的字串是顺序无关的)的开始位置
     * 字符串由小写英文字符组成，s,p的长度都不超过20100，输出的顺序没有关系
     * <p>
     * 思路： 1、遍历一遍字符串，如果当前的元素包含在p中，则遍历下面p.length()个元素(看其中的每个元素是不是都在p中，有则将当前元素的下标加入到结果当中)
     * 这样的时间复杂度为O(n2),在leetcode上不会超时
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] indexArr = initIndex(p);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (indexArr[s.charAt(i) - 'a'] > 0) {
                for (int j = i; j < s.length(); j++) {
                    if (indexArr[s.charAt(j) - 'a'] <= 0) {
                        indexArr = initIndex(p);
                        break;
                    }
                    if (j - i + 1 == p.length()) {
                        result.add(i);
                        indexArr = initIndex(p);
                        break;
                    }

                    indexArr[s.charAt(j) - 'a']--;
                }
            }
        }
        return result;
    }

    public int[] initIndex(String str) {
        int[] indexArr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            indexArr[str.charAt(i) - 'a']++;
        }
        return indexArr;
    }

    /**
     * 2、思路和上面的差不多主要是对象面的优化，主要是用一个right标记上次结果的位置，但是这样的效果也不是很好，因为每次都需要对indexArr进行重置
     */
    public List<Integer> findAnagrams1(String s, String p) {
        int[] indexArr = initIndex(p);
        List<Integer> result = new ArrayList<>();
        int right = 0;
        boolean isBreak = false;

        for (int i = 0; i < s.length(); i++) {
            if (i < right && right < s.length() && (s.charAt(i - 1) == s.charAt(right)) && !isBreak) {
                result.add(i);
                right++;
                continue;
            }

            if (indexArr[s.charAt(i) - 'a'] > 0) {
                for (int j = i; j < s.length(); j++) {
                    if (indexArr[s.charAt(j) - 'a'] <= 0) {
                        indexArr = initIndex(p);
                        isBreak = true;
                        break;
                    }
                    if (j - i + 1 == p.length()) {
                        result.add(i);
                        right = j + 1;
                        indexArr = initIndex(p);
                        isBreak = false;
                        break;
                    }

                    indexArr[s.charAt(j) - 'a']--;
                }
            }
            if (indexArr[s.charAt(right - 1) - 'a'] <= 0) {
                i = right - 1;
            }
        }
        return result;
    }

    /**
     * 3、从左边开始遍历数组，对已匹配的使用contains记录，当contains和p的长度相等时，进行判断是不是包含有符合条件的子字符串
     */
    public List<Integer> findAnagrams2(String s, String p) {
        int[] indexArr = initIndex(p);
        List<Integer> result = new ArrayList<>();
        int left = 0, contains = 0;
        for (int i = 0; i < s.length(); i++) {
            if (indexArr[s.charAt(i) - 'a'] > 0) {
                contains++;
            }
            indexArr[s.charAt(i) - 'a']--;
            if (contains == p.length()) {
                for(;left < i ; left++) {
                    if (i - left + 1 == p.length()) {
                        contains--;
                        indexArr[s.charAt(left) - 'a']++;
                        result.add(left++);
                        break;
                    }
                    if (indexArr[s.charAt(left) - 'a'] == 0) {
                        contains--;
                        indexArr[s.charAt(left++) - 'a']++;
                        break;
                    }
                    indexArr[s.charAt(left) - 'a']++;
                }
            }
        }
        return result;
    }
}
