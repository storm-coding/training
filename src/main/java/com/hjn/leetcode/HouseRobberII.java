package com.hjn.leetcode;

/**
 * 213. House Robber II
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one.
 * Meanwhile, adjacent houses have security system connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the
 * amount of money of each house, determine the maximum amount
 * of money you can rob tonight without alerting the police.
 */
public class HouseRobberII {
    /**
     * 题目意思： 你是一个专业的盗贼，计算抢劫一条街的房子。每个房子都包含一定数量的金钱。
     *             所有的房子围绕成一个圈。这意味着，第一间房子是挨着第二间的。
     *             同时，两间相邻的房子有警报系统，你如果同时抢劫相邻的房子会触发警报系统。
     *             给定一个非负的整数列表，代表每间房子的金额。在不触碰警报的情况下，求所能抢劫的最大金额。
     *
     * 思路：1、类似题 198，只是这里的房子是一个圆。那么第一位和最后一位不能同时存在。所以分别考虑对这两种情况，分别求解即可。
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] ans = new int[nums.length];
        boolean[] ansFlag = new boolean[nums.length];
        if (nums.length > 1) {
            //排除第一位
            ans[1] = nums[1];
            for (int i = 2; i < nums.length; i++) {
                ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
            }
            int result1 = ans[nums.length - 1];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = 0;
            }
            //排除最后位
            ans[nums.length - 2] = nums[nums.length - 2];
            for (int i = nums.length - 3; i >= 0; i--) {
                ans[i] = Math.max(ans[i + 1], nums[i] + ans[i + 2]);
            }
            return Math.max(result1,ans[0]);
        }else {
            return nums[0];
        }
    }


    /**
     * 2、递归求解，ans表示第i位的存储结果，ansFlag表示第ans的第i位是不是从第1位开始的
     */
    int[] ans;
    // 这个标记是不是从第一位开始的
    boolean[] ansFlag;
    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = -1;
        }
        ansFlag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ansFlag[i] = true;
        }
        return rob1(nums, 0, false);
    }

    /**
     * 从nums[index....nums.length-1]  可盗取的最大和
     *
     * @param nums  可盗取的街道房屋
     * @param index 从数组index开始到数组的最后
     * @return index到数组末尾可盗取的最大和
     */
    private int rob1(int[] nums, int index, boolean hasHead) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == nums.length - 1) {
            if (hasHead) {
                ans[index] = 0;
                ansFlag[index] = hasHead;
                return 0;
            } else {
                ans[index] = nums[index];
                ansFlag[index] = hasHead;
                return nums[index];
            }
        }

        if (ans[index] != -1 && ansFlag[index] == hasHead) {
            return ans[index];
        }
        if (index == 0) {
            ans[index] = Math.max(nums[index] + rob1(nums, index + 2, true), rob1(nums, index + 1, hasHead));
            ansFlag[index] = hasHead;
        } else {
            ans[index] = Math.max(nums[index] + rob1(nums, index + 2, hasHead), rob1(nums, index + 1, hasHead));
            ansFlag[index] = hasHead;
        }
        return ans[index];
    }


    /**
     * 3、递归过程不记录： Time Limit Exceeded
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return rob2(nums, 0, false);
    }

    /**
     * 从nums[index....nums.length-1]  可盗取的最大和
     *
     * @param nums  可盗取的街道房屋
     * @param index 从数组index开始到数组的最后
     * @return index到数组末尾可盗取的最大和
     */
    private int rob2(int[] nums, int index, boolean hasHead) {
        if (index >= nums.length) {
            return 0;
        }
        if (index == nums.length - 1) {
            if (hasHead) {
                return 0;
            } else {
                return nums[index];
            }
        }

        if (index == 0) {
            return Math.max(nums[index] + rob2(nums, index + 2, true), rob2(nums, index + 1, hasHead));
        } else {
            return Math.max(nums[index] + rob2(nums, index + 2, hasHead), rob2(nums, index + 1, hasHead));
        }
    }

    public static void main(String[] args) {
        HouseRobberII robber = new HouseRobberII();
        System.out.println(robber.rob(new int[]{1, 3, 1, 3, 100}));
    }
}
