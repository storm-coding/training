package com.hjn.leetcode;


import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * leetcode 347. Top K Frequent Elements
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    /**
     * 题目意思： 给定一个非空的int数组，返回出现次数最常见的k个元素
     * 注意点：你可以假定k总是有效的，1 ≤ k ≤ 数组的长度
     * 算法时间复杂度要优于nlogn
     * 思路： 1、遍历一遍数组，使用map存储每个数字出现的次数
     * 2、遍历map，使用优先队列存储出现次数最多的k个数
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (k < 0) {
            return null;
        }
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], numsMap.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(k, (o1, o2) -> o1.getValue() - o2.getValue());
        int len = 0;
        for (int n : numsMap.keySet()) {
            if (len < k) {
                queue.add(new Pair(n, numsMap.get(n)));
                len++;
            } else if (numsMap.get(queue.peek().getKey()) < numsMap.get(n)) {
                queue.poll();
                queue.add(new Pair(n, numsMap.get(n)));
            }
        }

        return queue.stream().map(Pair::getKey).collect(Collectors.toList());
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TopKFrequentElements topK = new TopKFrequentElements();
        System.out.println(topK.topKFrequent(new int[]{5, 2, 5, 3, 5, 3, 1, 1, 3}, 2));
    }
}
