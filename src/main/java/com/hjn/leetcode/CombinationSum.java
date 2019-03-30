package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 */
public class CombinationSum {
    /**
     * 题目意思：给定一个不重复数字的集合candidates和一个目标数target.
     *           在candidates中找出所有唯一的组合使得他们的和为target
     *           相同的数字可以使用多次
     * 提示：    1、所有的数都为整数
     *           2、结果中不能包含重复的组合
     * 思路：    遍历candidates对于遍历中每个元素cur，target-cur之后再递归调用遍历candidates直到target < 0
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(candidates.length == 0) {
            return result;
        }
        combinationSum(candidates,target,0,result,new ArrayList<>());
        return result;
    }

    private void combinationSum(int[] candidates, int target,int start, List<List<Integer>> result,List<Integer> items) {
        if(target <= 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            items.add(candidates[i]);
            if(candidates[i] == target) {
                result.add(new ArrayList<>(items));
            }
            combinationSum(candidates,target-candidates[i],i,result,items);
            items.remove(items.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(new int[] {2,3,5},8);
        System.out.println(result);
    }
}
