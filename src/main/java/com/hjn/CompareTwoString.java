package com.hjn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoz on 2018/12/22.
 */
public class CompareTwoString {
    public static boolean twoStringCompriseIsEqual(String str1, String str2) {
        // TODO 现在假定两个都为null的情况返回true，
        if(str1 == null && str2 == null) {
            return true;
        }

        if (str1 == null || str2 == null) {
            return false;
        }

        if (str1.length() != str2.length()) {
            return false;
        }

        return compareTwoString(str1,str2);
    }


    private static boolean compareTwoString(String str1, String str2) {
        Map<Character,Integer> str1Map = statisticalCharNumOfString(str1);
        Map<Character,Integer> str2Map = statisticalCharNumOfString(str2);

        if(str1Map.size() != str2Map.size()) {
            return false;
        }

        for(char key : str1Map.keySet()) {
            if (str1Map.get(key) != str2Map.get(key)) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character,Integer> statisticalCharNumOfString(String str) {
        Map<Character,Integer> strMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            if (strMap.get(str.charAt(i)) == null) {
                strMap.put(str.charAt(i),1);
            } else {
                strMap.put(str.charAt(i),strMap.get(str.charAt(i)) + 1);
            }
        }
        return strMap;
    }

}
