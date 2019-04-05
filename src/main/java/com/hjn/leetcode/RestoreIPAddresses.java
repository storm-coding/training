package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 93.Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 */
public class RestoreIPAddresses {
    /**
     * 题目意思：给定一个只包含数字的字符串，返回该字符串所能表示的所有有效ip的组合
     *
     * 思路： 对于当前的字符串，截取1，2，3如果符合标准，递归调用剩余的字符串
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        return restoreIpAddresses(s, new ArrayList<>(), new ArrayList<>());
    }

    public List<String> restoreIpAddresses(String s, List<String> ipList, List<String> seg) {
        if (seg.size() == 4 && s.length() == 0) {
            String ip = "";
            for (int i = 0; i < seg.size() - 1; i++) {
                ip += seg.get(i) + ".";
            }
            ip += seg.get(seg.size() - 1);
            ipList.add(ip);
            return ipList;
        }
        // 剪支
        if (s.length() == 0 || seg.size() == 4) {
            return ipList;
        }

        int len = s.length() < 3 ? s.length() : 3;
        for (int i = 0; i < len; i++) {
            String num = s.substring(0, i + 1);
            if (num.startsWith("0") && num.length() > 1) {
                continue;
            }
            if (Integer.parseInt(num) <= 255) {
                seg.add(num);
                restoreIpAddresses(s.substring(i + 1), ipList, seg);
                seg.remove(seg.size()-1);
            }
        }

        return ipList;
    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIP = new RestoreIPAddresses();
        List<String> ips = restoreIP.restoreIpAddresses("010010");
        for (String ip : ips) {
            System.out.println(ip);
        }
    }
}
