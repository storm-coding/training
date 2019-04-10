package com.hjn.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 120. Triangle
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 */
public class Triangle {

    /**
     * 题目意思：给定一个三角形，找出找出从上到下的路径使得他们的和最小。每一步只能移动到下一行的相邻位置
     *
     * 思路; 总体思路和方法2、3一样，只是这里自底向上，依次求解
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int line = triangle.get(triangle.size() - 1).size();
        int[][] ans = new int[row][line];
        assert triangle != null && !triangle.isEmpty();


        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (i == triangle.size() - 1) {
                    ans[i][j] = triangle.get(i).get(j);
                } else {
                    ans[i][j] = triangle.get(i).get(j) + Math.min(ans[i + 1][j], ans[i + 1][j + 1]);
                }
            }
        }
        return ans[0][0];
    }


    /**
     * 方法2，递归求解，在方法三的基础上记录之前已经计算过的节点
     *
     * @param triangle
     * @param level    第几层（第几个list）
     * @param element  level层的element位置的元素
     * @param ans      记录已计算的值
     * @return
     */
    public int count(List<List<Integer>> triangle, int level, int element, int[][] ans) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(element);
        }
        if (ans[level][element] == -1) {
            ans[level][element] = Math.min(
                    count(triangle, level + 1, element, ans) + triangle.get(level).get(element),
                    count(triangle, level + 1, element + 1, ans) + triangle.get(level).get(element)
            );
        }
        return ans[level][element];
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int[][] ans;
        ans = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        assert triangle != null && !triangle.isEmpty();
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                ans[i][j] = -1;
            }
        }

        return count(triangle, 0, 0, ans);
    }

    /**
     * 方法三 递归求解 time limit exceeded
     *
     * @return
     */
//    private int count1(List<List<Integer>> triangle, int level, int element) {
//        if (level == triangle.size() - 1)
//            return triangle.get(level).get(element);
//        return Math.min(
//                count(triangle, level + 1, element) + triangle.get(level).get(element),
//                count(triangle, level + 1, element + 1) + triangle.get(level).get(element)
//        );
//    }
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(2));
        nums.add(Arrays.asList(3, 4));
        nums.add(Arrays.asList(6, 5, 7));
        nums.add(Arrays.asList(4, 1, 8, 3));
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(nums));
    }
}
