package com.hjn.leetcode;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * leetCode345
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Note: The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
    /**
     * 题目意思： 编写一个函数，反转其中的元音字符。y不算元音
     *
     * 思路： 做char数组两边开始向中间遍历，如果当前有索引的字符不是元音则结束本次遍历，
     *        反之两边索引的字符都是元音则依次交换
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            if (!contains(chars, left)) {
                left++;
                continue;
            }
            if (!contains(chars, right)) {
                right--;
                continue;
            }
            char t = chars[left];
            chars[left++] = chars[right];
            chars[right--] = t;
        }
        return new String(chars);
    }

    private boolean contains(char[] c, int index) {
        if (c[index] == 'A'
                || c[index] == 'a'
                || c[index] == 'E'
                || c[index] == 'e'
                || c[index] == 'I'
                || c[index] == 'i'
                || c[index] == 'O'
                || c[index] == 'o'
                || c[index] == 'U'
                || c[index] == 'u') {
            return true;
        }
        return false;
    }
}
