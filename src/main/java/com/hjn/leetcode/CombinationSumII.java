package com.hjn.leetcode;

import java.util.*;

/**
 * 40. Combination Sum II
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 */
public class CombinationSumII {
    /**
     * 题目意思：给定一个候选的数字集合和一个目标数target，
     *           在集合中找出所有的唯一组合，使得他们的和等于sum
     *           每个数字在集合中只能使用一次
     *
     * 思路：类似39题，只是在这个问题中有去重的问题
     *       1、使用set进行去重
     */
    private Set<String> visit = new HashSet<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void combinationSum(int[] candidates, int target, int start, List<Integer> items) {
        if (target <= 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            items.add(candidates[i]);
            if (candidates[i] == target) {
                String s = items.toString();
                if (!visit.contains(s)) {
                    result.add(new ArrayList<>(items));
                    visit.add(s);
                }
            }
            combinationSum(candidates, target - candidates[i], i + 1, items);
            items.remove(items.size() - 1);
        }
    }

    /**
     * 2、使用一个变量来标记前驱节点，如果在下次遍历中判断是不是和前驱节点相等，来达到去重的效果
     */
    List<List<Integer>> result1 = new ArrayList<>();
    Integer pre = -1;
    public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return result1;
        }
        Arrays.sort(candidates);
        combinationSum_1(candidates, target, 0, new ArrayList<>());
        return result1;
    }

    private void combinationSum_1(int[] candidates, int target, int start, List<Integer> items) {
        if (target <= 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] == pre) {
                continue;
            }
            items.add(candidates[i]);
            if (candidates[i] == target) {
                result1.add(new ArrayList<>(items));
            }
            combinationSum_1(candidates, target - candidates[i], i + 1, items);
            items.remove(items.size() - 1);
            pre = candidates[i];
        }
    }

    public static void main(String[] args) {
        CombinationSumII cs = new CombinationSumII();
        System.out.println(cs.combinationSum2_1(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}
