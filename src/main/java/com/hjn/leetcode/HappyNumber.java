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
     * 题目意思： 编写一个函数判断给定一个数字是不是快乐数，快乐数指的是，这个数的每一位的乘积之和等于1、或者和的乘积重复上面步骤等于1
     * 思路： 1、计算给定数每一位的乘积，之后判断是不是等于1或者在之前的计算和中出现过
     *        2、都过都不符合上述条件，则重新进行上面步骤
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
        while (true) {
            set.add(n);
            while (n > 0) {
                int last = n % 10;
                products += productArr[last];
                n = n/10;
            }
            if (products == 1) {
                return true;
            }
            if (set.contains(products)) {
                return false;
            }
            n = products;
            products = 0;
        }

    }
}
