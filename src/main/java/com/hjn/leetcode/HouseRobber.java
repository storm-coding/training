package com.hjn.leetcode;

/**
 * 198. House Robber
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is
 * that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {
    /**
     * 题目意思： 你是一个专业的盗贼，计划抢劫一条街的房子。没个房子都包含一定金钱。
     * 唯一的约束是。如果连续抢劫两座房子，那么就会触发安全系统，自动联系警察。
     * 给定一个非负整数的列表，表示每个房子的金钱，求出在不触碰警报的情况下，所能抢劫的最大金额
     * <p>
     * 思路： 1、自底向上，遍历列表nums，对于每个当前节点有如下表达式：
     *        f(x) = max(f(x+1) + f(i+2)+nums[x])。f(x)表示从0-x所能抢劫的最大金额
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ans = new int[nums.length];
        ans[nums.length - 1] = nums[nums.length - 1];
        if (ans.length > 1) {
            ans[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        }
        for (int i = nums.length - 3; i >= 0; i--) {
            ans[i] = Math.max(ans[i + 1], nums[i] + ans[i + 2]);
        }
        return ans[0];
    }


    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
        }

        return rob1(nums, 0, ans);
    }

    /**
     * 2、递归求解。在递归的过程中使用数组ans记录下之前计算过的结果
     * 从nums[index....nums.length-1]  可盗取的最大和
     *
     * @param nums  可盗取的街道房屋
     * @param index 从数组index开始到数组的最后
     * @return index到数组末尾可盗取的最大和
     */
    private int rob1(int[] nums, int index, int[] ans) {
        if (index >= nums.length) {
            return 0;
        }
        if (ans[index] != -1) {
            return ans[index];
        }
        if (index == nums.length - 1) {
            ans[index] = nums[index];
            return ans[index];
        }
        ans[index] = Math.max(nums[index] + rob1(nums, index + 2, ans), rob1(nums, index + 1, ans));
        return ans[index];
    }


    /**
     * 3、递归求解，不记录之前计算过的结果。Time Limit Exceeded
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        return rob2(nums, 0);
    }

    /**
     * @param nums  可盗取的街道房屋
     * @param index 从数组index开始到数组的最后
     * @return index到数组末尾可盗取的最大和
     */
    private int rob2(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == nums.length - 1) {
            return nums[index];
        }
        return Math.max(nums[index] + rob2(nums, index + 2), rob2(nums, index + 1));
    }

    public static void main(String[] args) {
        HouseRobber robber = new HouseRobber();
        System.out.println(robber.rob(new int[]{1, 2, 3, 1}));
    }
}
