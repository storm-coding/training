package com.hjn.leetcode;

/**
 * leetcode344
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 */
public class ReverseString {

    /**
     * 题目意思： 编写一个反转函数。输入是一个字符串(ascii)，不能使用额外的空间，只能在这个数组当中进行修改
     * <p>
     * 思路： 做char数组两边开始向中间遍历，依次交换
     */
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length;

        while (left < right) {
            char t = s[left];
            s[left] = s[right];
            s[right] = s[left];
            left++;
            right--;
        }
    }
}
