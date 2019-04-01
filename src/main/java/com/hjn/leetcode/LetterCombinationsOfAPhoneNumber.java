package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 */
public class LetterCombinationsOfAPhoneNumber {
    /**
     * 题目意思： 给定一个包含2-9的字符串，返回这些字符串所能表示的所有字母组合
     * 一个数字对字母的映射（电话上的按钮），1不映射任何字母
     * <p>
     * 思路： 根据描述可得通式：f(n) = f(1) + f(2-n),
     * 遍历给出的字符串，对于遍历中的每个当前字符串x,0-x数字的组合等于0-x-1的组合 加上x的所能映射的所有情况
     */
    String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null) {
            return result;
        }
        return phoneNumber(digits, result);
    }

    public List<String> phoneNumber(String digits, List<String> digitsList) {
        if (digits.length() == 0) {
            return digitsList;
        }
        String s = nums[Character.digit(digits.charAt(0), 10)];
        if (s.length() != 0) {
            if (digitsList.isEmpty()) {
                for (int i = 0; i < s.length(); i++) {
                    digitsList.add(String.valueOf(s.charAt(i)));
                }
            } else {
                List<String> newList = new ArrayList<>();
                for (String str : digitsList) {
                    for (int i = 0; i < s.length(); i++) {
                        newList.add(str + String.valueOf(s.charAt(i)));
                    }
                }
                digitsList = newList;
            }
        }
        return phoneNumber(digits.substring(1, digits.length()), digitsList);
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber phoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> list = phoneNumber.letterCombinations("23");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
