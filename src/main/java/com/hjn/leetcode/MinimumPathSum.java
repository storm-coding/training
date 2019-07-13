package com.hjn.leetcode;

/**
 * 64
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */
public class MinimumPathSum {
    /**
     * 题目意思：给定一个非负的m*n的二维矩阵，找出一条从左上角到右下角的路径，使得他们的和最小
     * <p>
     * 思路： 动态规划求解。f(x,y) = grid(x,y)+min(f(x-1,y),f(x,y-1))
     *
     * @param grid 二维矩阵
     * @return  路径最小和
     */
    public int minPathSum(int[][] grid) {
        assert grid != null && grid.length > 0;
        int[][] ans = new int[grid.length][grid[0].length];
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    ans[i][j] = grid[i][j];
                    continue;
                }
                if (i == 0) {
                    ans[i][j] = ans[i][j - 1] + grid[i][j];
                    continue;
                }
                if (j == 0) {
                    ans[i][j] = ans[i - 1][j] + grid[i][j];
                    continue;
                }
                ans[i][j] = Math.min(ans[i - 1][j], ans[i][j - 1]) + grid[i][j];
            }
        }
        return ans[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 递归求解。使用
     */
    public int minPathSum(int[][] grid, int row, int line, int[][] ans) {
        int r = grid.length - 1;
        int l = grid[r].length - 1;
        if (row == r && line == l) {
            return grid[row][line];
        }
        if (ans[row][line] == -1) {
            ans[row][line] = grid[row][line] + Math.min(minPathSum(grid, row, line + 1, ans), minPathSum(grid, row + 1, line, ans));
        }
        return ans[row][line];
    }


    public int minPathSum2(int[][] grid) {
        assert grid != null && grid.length > 0;
        return minPathSum2(grid, 0, 0);
    }

    public int minPathSum2(int[][] grid, int row, int line) {
        int r = grid.length - 1;
        int l = grid[r].length - 1;
        if (row == r && line == l) {
            return grid[row][line];
        }
        if (row == r) {
            return grid[row][line] + minPathSum2(grid, row, line + 1);
        }
        if (line == l) {
            return grid[row][line] + minPathSum2(grid, row + 1, line);
        }
        return grid[row][line] + Math.min(minPathSum2(grid, row + 1, line), minPathSum2(grid, row, line + 1));
    }

    /**
     * [1,3,1],
     * [1,5,1],
     * [4,2,1]
     */
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSum mps = new MinimumPathSum();
        System.out.println(mps.minPathSum(arr));
    }
}
