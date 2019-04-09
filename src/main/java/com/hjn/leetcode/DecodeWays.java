package com.hjn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 */
public class DecodeWays {
    /**
     * 题目意思： 一个字符串信息包含A-Z,它与数字之间的匹配如下：
     * 'A' -> 1
     * 'B' -> 2
     * 'Z' -> 26
     * 给定一个非空的数字字符串，找出所有使用上述关系破解它的总数
     * <p>
     * 思路：dp思想，从字符串最后一位开始计算，使用一个一维数组ans记录之前的计算结果。
     *       遍历过程当前字符串的位置有如下情况：
     *       1、当前位置为0，那么ans[i] = 0
     *       2、当前位置不为0，当前位置的值默认等于后一位的值： ans[i] = ans[i+1]
     *       3、在2的情况下，从当前位置和后面一位构成的数字小于<=26 ans[i] = ans[i+2]
     */
    public int numDecodings(String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = -1;
        }
        if (s.length() == 0) {
            return 0;
        }
        if (Integer.valueOf(s.substring(s.length() - 1)) > 0) {
            ans[s.length() - 1] = 1;
        } else {
            ans[s.length() - 1] = 0;
        }
        if (s.length() == 1) {
            return ans[0];
        }
//        int n = Integer.valueOf(s.substring(s.length() - 2));
//        if (n == 0 || s.charAt(s.length() - 2) == '0' || (n > 26 && n % 10 == 0)) {
//            ans[s.length() - 2] = 0;
//        } else if (n < 10 || n % 10 == 0 || n > 26) {
//            ans[s.length() - 2] = 1;
//        } else {
//            ans[s.length() - 2] = 2;
//        }

        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ans[i] = 0;
            } else {
                ans[i] = ans[i + 1];
                int n2 = Integer.valueOf(s.substring(i, i + 2));
                if (n2 <= 26) {
                    if (i == s.length() - 2) {
                        ans[i]++;
                    } else {
                        ans[i] += ans[i + 2];
                    }
                }
            }
        }
        return ans[0];
    }

    /**
     * 2： 递归求解。求解s，即：求s：f(s) = f(s-1) + f(s-2),
     *     因为在递归计算的过程中会存在重复计算的问题，使用一个数组（也可以使用map记录）记录之前计算的值，
     */
    public int numDecodings1(String s) {
        int[] ans = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ans[i] = -1;
        }
        numDecodings1(s, ans, 0);
        return ans[0];
    }

    private int numDecodings1(String s, int[] ans, int index) {
        if (ans[index] != -1) {
            return ans[index];
        }
        if (s.length() == 0 || s.charAt(0) == '0') {
            ans[index] = 0;
            return 0;
        }
        if (s.length() == 1) {
            if (Integer.valueOf(s) > 0) {
                ans[index] = 1;
                return 1;
            } else {
                ans[index] = 0;
                return 0;
            }
        }
        if (s.length() == 2 && Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 26) {
            if (Integer.valueOf(s) % 10 == 0) {
                ans[index] = 1;
                return 1;
            } else {
                ans[index] = 2;
                return 2;
            }
        }

        if (s.length() >= 2 && Integer.valueOf(s.substring(0, 2)) <= 26) {
            ans[index] = numDecodings1(s.substring(2), ans, index + 2) + numDecodings1(s.substring(1), ans, index + 1);
        } else {
            ans[index] = numDecodings1(s.substring(1), ans, index + 1);
        }
        return ans[index];
    }

    /**
     * 3、和2一样，只是使用map存储之前计算过的结果。不过map的效率没有数组好
     */
    Map<String, Integer> ans = new HashMap<>();
    public int numDecodings2(String s) {
        if (ans.get(s) != null) {
            return ans.get(s);
        }
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            if (Integer.valueOf(s) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (s.length() == 2 && Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 26) {
            if (Integer.valueOf(s) % 10 == 0) {
                return 1;
            } else {
                return 2;
            }
        }

        if (s.length() >= 2 && Integer.valueOf(s.substring(0, 2)) <= 26) {
            ans.put(s, numDecodings2(s.substring(2)) + numDecodings2(s.substring(1)));
        } else {
            ans.put(s, numDecodings2(s.substring(1)));
        }
        return ans.get(s);
    }


    /**
     * 直接递归，Time Limit Exceeded
     */
    public int numDecodings3(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            if (Integer.valueOf(s) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (s.length() == 2 && Integer.valueOf(s) > 0 && Integer.valueOf(s) <= 26) {
            if (Integer.valueOf(s) % 10 == 0) {
                return 1;
            } else {
                return 2;
            }
        }

        if (s.length() >= 2 && Integer.valueOf(s.substring(0, 2)) <= 26) {
            return numDecodings3(s.substring(2)) + numDecodings3(s.substring(1));
        } else {
            return numDecodings3(s.substring(1));
        }
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("12"));
    }
}
