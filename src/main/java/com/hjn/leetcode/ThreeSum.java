package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode015
 * Given an array nums of n integers, are there elements a, b, c
 * in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
    /**
     * 题目意思： 给出一个int数组，是不是存在元素a、b、c使得a+b+c=0，
     *            找出所有这样独一无二的组合使得他们的和为0
     * 思路： 1、先对数组进行排序
     *        2、遍历数组，对当前的节点，生于两个节点使用2Sum的思路进行查找
     *        3、对符合节点的集合进行去重
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if ((left != i) && (right != i)) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        boolean find = false;
                        for (List<Integer> list : result) {

                             if ((list.get(0) == nums[i] && list.get(1) == nums[left] && list.get(2) == nums[right]) ||
                                    (list.get(0) == nums[i] && list.get(1) == nums[right] && list.get(2) == nums[left]) ||
                                    (list.get(0) == nums[left] && list.get(1) == nums[i] && list.get(2) == nums[right]) ||
                                    (list.get(0) == nums[left] && list.get(1) == nums[right] && list.get(2) == nums[i]) ||
                                    (list.get(0) == nums[right] && list.get(1) == nums[left] && list.get(2) == nums[i]) ||
                                    (list.get(0) == nums[right] && list.get(1) == nums[i] && list.get(2) == nums[left])
                                    ) {
                                 find = true;
                                break;
                            }
                        }
                        if (!find) {
                            List<Integer> l = new ArrayList<>();
                            l.add(nums[i]);
                            l.add(nums[right]);
                            l.add(nums[left]);
                            result.add(l);
                        }
                        left++;
                        right--;
                    } else {
                        if (nums[i] + nums[left] + nums[right] > 0) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                } else {
                    if (left == i) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> l = ts.threeSum(nums);
        System.out.println(l.size());
    }
}
