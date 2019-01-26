package com.hjn.leetcode;

/**
 * leetCode125
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    /**
     * 题目意思:  给出一个字符串，判断是不是回文串，只考虑数字和字母
     *
     * 思路： 分别从字符串两侧向中间靠近，在当前字符是数字或字母的情况下左边第n个和右边第n个是否相等
     */
    public boolean isPalindrome(String s) {
//        s = s.toLowerCase();  使用jdk自带的方法，先将字符串转成忽略大小写的，这种方式比较简单但是会增加一次循环
        if (s == null) {
            return false;
        }
        if (s.trim().length() == 0) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (!isAlphanumeric(s, left)) {
                left++;
                continue;
            }
            if (!isAlphanumeric(s, right)) {
                right--;
                continue;
            }

            if ( (s.charAt(left) == s.charAt(right)) ||
                    (s.charAt(left) >= 'A' && ((s.charAt(left) - s.charAt(right)) * (s.charAt(left) - s.charAt(right))  == 1024 ))) {
                    // 这种情况，自己判断忽略大小写是否相等  英文字符在ascii中相差32（a-A=32）,32*32=1024
                left++;
                right--;
                continue;
            }
            return false;
        }

        return true;
    }
    // Character.isLetterOrDigit(s.charAt(index))  和这个方法作用一样
    boolean isAlphanumeric(String s, int index) {
        int charNum = s.charAt(index);
        if (charNum < '0' || (charNum > '9' && charNum < 'A') || (charNum > 'Z' && charNum < 'a') || charNum > 'z') {
            return false;
        }
        return true;
    }

}
