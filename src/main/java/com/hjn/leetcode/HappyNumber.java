package com.hjn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode202
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 */
public class HappyNumber {

    /**
     * 题目意思： 编写一个函数判断给定一个数字是不是快乐数，快乐数指的是，这个数的每一位的乘积之和如果能等于一
     * 思路： 将这个数的每一位相乘，如果最后乘积等于1，返回true，否则将这个数添加到set中，下次循环是判断这个乘积是不是在这个set中
     */
    public boolean isHappy(int n) {
        int[] productArr = new int[10];
        productArr[0] = 0;
        productArr[1] = 1;
        productArr[2] = 4;
        productArr[3] = 9;
        productArr[4] = 16;
        productArr[5] = 25;
        productArr[6] = 36;
        productArr[7] = 49;
        productArr[8] = 64;
        productArr[9] = 81;

        int products = 0;
        Set<Integer> set = new HashSet<>();
        while (n > 1) {
            set.add(n);
            while (n > 0) {
                int last = n % 10;
                products += productArr[last];
                n = n/10;
            }
            if (set.contains(products)) {
                return false;
            }
            n = products;
            products = 0;
        }

        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        return false;
    }
}
