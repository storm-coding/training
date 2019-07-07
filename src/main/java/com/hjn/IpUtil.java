package com.hjn;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class IpUtil {
    /**
     * ipToInt：实现IP与整数的相互转换
     * 字符串ip转数字，java没有无符号类型，这里使用long型存储
     * @param ip 字符串ip
     * @return 数字类型ip
     */
    public static long ipToInt(String ip) {
        int[] ipNums = ipToIntArr(ip);
        return ((long) ipNums[0] << 24) + (ipNums[1] << 16) + (ipNums[2] << 8) + ipNums[3];
    }

    /**
     * 数字类型 ip转字符串ip
     * @param ip 数字类型ip long类型
     * @return 字符串ip
     */
    public static String ipToStr(long ip) {
        if (ip < 0 || ip > 4294967295L) {
            throw new IllegalArgumentException("ip is less 0 or more 4294967295L");
        }
        StringBuilder ipString = new StringBuilder();
        ipString.append(ip >> 24);
        ipString.append(".");
        ipString.append((ip & 0x00ff0000) >> 16);
        ipString.append(".");
        ipString.append((ip & 0x0000ff00) >> 8);
        ipString.append(".");
        ipString.append((ip & 0x000000ff));

        return ipString.toString();
    }

    private static int[] ipToIntArr(String ip) {
        StringBuilder ipPart = new StringBuilder();
        int[] nums = new int[4];
        int numsIndex = 0;

        for (char c : ip.toCharArray()) {
            if (c == '.') {
                nums[numsIndex++] = ipPartToInt(ipPart.toString());
                ipPart = new StringBuilder();
            } else {
                ipPart.append(c);
            }
        }
        nums[numsIndex] = ipPartToInt(ipPart.toString());
        if (numsIndex != 3) {
            throw new NumberFormatException("ip format error ip=" + ip);
        }
        return nums;
    }

    private static int ipPartToInt(String s) {
        if (s.length() < 1 || s.length() > 3) {
            throw new NumberFormatException("ip format error, ip part len error, ipPart =" + s);
        }
        int ipPart = 0;
        for (char c : s.toCharArray()) {
            int cNum = c - '0';
            if(cNum > 9 || cNum < 0){
                throw new IllegalArgumentException("ip format error ipPart =" + s);
            }
            ipPart = ipPart * 10 + cNum;
        }
        if (ipPart > 255) {
            throw new NumberFormatException("ip format error, ip part is more 255, ipPart =" + s);
        }
        return ipPart;
    }

    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();
        map.put(null,"11");
        System.out.println(map.get(null));
    }
}
