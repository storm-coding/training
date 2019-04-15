package com.hjn.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * 416. Partition Equal Subset Sum
 * <p>
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 */
public class PartitionEqualSubsetSum {

    /**
     * 题目意思： 给定一个只包含正数的非空数组，找出数组是不是能分割成两部分使得他们的和相等
     *
     * 思路： 01背包问题。只是这里的背包是等于，大小为所有数和的1/2.
     *        初始化一个boolean[][] 的二维数组ans，遍历数组，对于每个当前的元素i。
     *        遍历0-sum,也就是nums[0,i]中是不是存在和为[0,sum]的集合
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean ans[][] = new boolean[nums.length][sum + 1];

        for (int j = 0; j <= sum; j++) {
            if (nums[0] == j || j == 0) {
                ans[0][j] = true;
            } else {
                ans[0][j] = false;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (ans[i - 1][j]) {
                    ans[i][j] = true;
                    int t = j + nums[i];
                    if (t < sum) {
                        ans[i][t] = true;
                    }
                    if (t == sum) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 递归求解。递推表达式为：f(n,c) = f(n-1,c)|| f(n-1,c-nums[n])
     * 其中n表示数组的下标，c还需要在nums[0-c]找出一组数使得他们的和为c
     */
    Boolean[][] ans;
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        ans = new Boolean[nums.length][sum + 1];
        return canPartition1(nums, 0, sum);
    }

    public Boolean canPartition1(int[] nums, int index, int sum) {
        if (sum < 0 || index == nums.length) {
            return Boolean.FALSE;
        }
        if (sum == 0) {
            return Boolean.TRUE;
        }
        if (ans[index][sum] != null) {
            return ans[index][sum];
        }
        ans[index][sum] = canPartition1(nums, index + 1, sum) || canPartition1(nums, index + 1, sum - nums[index]);
        return ans[index][sum];
    }

    /**
     * 不记录之前的计算结果的递归求解。Time Limit Exceeded
     */
    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;

        return canPartition2(nums, 0, sum);
    }

    public boolean canPartition2(int[] nums, int index, int sum) {
        if (sum < 0 || index == nums.length) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        return canPartition2(nums, index + 1, sum) || canPartition2(nums, index + 1, sum - nums[index]);
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum pes = new PartitionEqualSubsetSum();
        System.out.println(pes.canPartition(new int[]{3, 3, 3, 4, 5}));
    }
}
