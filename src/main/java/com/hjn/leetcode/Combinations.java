package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {
    /**
     * 题目意思：给定两个整数n和k，返回所有k个数的组合他们的范围在[1,n]之间
     * <p>
     * 思路： 从1到n遍历。每次添加当前元素后递归调用求解剩余的数字区间。当得到的组合等于k时放进结果集中
     *        在回溯的时候可以进行剪支优化：剩余的区间判断是不是能填满k个元素。不能则没必要继续向下进行。
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        combine(n, 1, k, result, new ArrayList<>());
        return result;
    }

    /**
     * 从start到n中选择k个元素
     *
     * @param n     最大的数
     * @param start 从该数开始进行运算
     * @param k     一共需要多少个数
     * @param list  存放最后的结果
     * @param items 用临时存放单个结果
     */
    private void combine(int n, int start, int k, List<List<Integer>> list, List<Integer> items) {
        if (items.size() == k) {
            list.add(new ArrayList<Integer>(items));
            return;
        }

        // 当剩余的元素中没有足够的元素，则进行剪支
        for (int i = start; i <= n && (n - start + 1 >= k - items.size()); i++) {
            items.add(i);
            combine(n, ++start, k, list, items);
            items.remove(items.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> list = combinations.combine(4, 2);
        System.out.println(list);
    }
}
