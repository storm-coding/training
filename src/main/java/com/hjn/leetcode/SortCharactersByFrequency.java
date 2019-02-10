package com.hjn.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * leetcode451
 * Given a string, sort it in decreasing order based on the frequency of characters.
 */
public class SortCharactersByFrequency {
    /**
     * 题目意思：给定一个字符串，按字符出现的频率进行降序排列
     *
     * 思路1： 1、使用map对每个字符进行统计
     *        2、使用冒泡思路对字符进行输出
     */
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }

        String result = "";
        while (map.size() > 0) {
            Character temp = null;
            for (char c : map.keySet()) {
                if (temp == null) {
                    temp = c;
                    continue;
                }
                if (map.get(c) > map.get(temp)) {
                    temp = c;
                }
            }
            for (int i = 0; i < map.get(temp); i++) {
                result += temp;
            }
            map.remove(temp);
        }

        return result;
    }

    /**
     *思路2： 在统计之后利用，TreeMap来进行排序输出
     */
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        StringBuilder result = new StringBuilder();
        Map<Integer,String> tMap = new TreeMap<>();
        for(Map.Entry<Character,Integer> m : map.entrySet()) {
            tMap.put(m.getValue(),tMap.getOrDefault(m.getValue(),"") + m.getKey());
        }
        for(Map.Entry<Integer,String> m : tMap.entrySet()) {
            for(char c : m.getValue().toCharArray()) {
                for (int i = 0; i < m.getKey(); i++) {
                    result.append(c);
                }
            }
        }

        return result.reverse().toString();
    }
        /**
         * lambda 表达式解法，参考leetcode
         */
    public String frequencySort2(String s) {
        return s.chars().mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .flatMap(e -> Collections.nCopies(e.getValue().intValue(),e.getKey()).stream())
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        SortCharactersByFrequency sb = new SortCharactersByFrequency();
        System.out.println(sb.frequencySort1("tree"));
    }
}
