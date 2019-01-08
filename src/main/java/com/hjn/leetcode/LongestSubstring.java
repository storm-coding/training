package com.hjn.leetcode;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LeetCode 003
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class LongestSubstring {
    /**
     *     最长字串，解决方法：在left和right之间的表示是不重复的。时间复杂度O(1)。leetcode时间34 ms
     *     使用数组表示ascii对应的字符
     */
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = -1;
        int result = 0;
        int temp = 0;
        int strArr[] = new int[256];
        while (left < s.length()){

            if( (right < s.length()-1) && (strArr[s.charAt(right+1)] == 0)){
                strArr[s.charAt(++right)] = 1;
                temp++;
                if(temp>result) {
                    result = temp;
                }
            }else{
                strArr[s.charAt(left)] = 0;
                temp--;
                left++;
            }
        }
        return result;
    }

    /**
     * 思路和上面一样。不重复的元素使用hashSet保存。leetcode时间51 ms
     */
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> charNum = new HashSet<>();
        int left = 0;
        int right = -1;
        int result = 0;
        while (left < s.length()) {
            if (right < s.length() -1 && !charNum.contains(s.charAt(right + 1))) {
                charNum.add(s.charAt(++right));
                result = Math.max(result, charNum.size());
            } else {
                charNum.remove(s.charAt(left++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }
}
