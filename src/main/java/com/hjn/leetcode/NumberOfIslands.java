package com.hjn.leetcode;

/**
 * 200. Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    //标记节点(i,j)是不是已经被访问。可以省去，使用grid本身作为标记: grid[i][j] = 1 => grid[i][j] = 0
    boolean[][] visited;
    int result = 0;
    private int[][] range = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 题目意思： 给定一个只包含1，0的二维数组，1表示岛屿，0表示水域，统计岛屿的个数
     *            一个岛屿是被水围绕的，陆地由它横向和纵向相邻的陆地组成。
     *            你可以二维数组的周围都是水域
     *
     * 思路： 类似79。不同的是，此题的每个数组节点只能用一次。因此在回溯的过程不需要将状态重置
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return result;
        }
        visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    searchLands(grid, new int[]{i, j});
                }
            }
        }

        return result;
    }

    public void searchLands(char[][] grid, int[] lastNode) {
        visited[lastNode[0]][lastNode[1]] = true;
        for (int[] step : range) {
            int r = lastNode[0] + step[0];
            int l = lastNode[1] + step[1];
            if (r >= 0 && r < grid.length && l >= 0 && l < grid[0].length && !visited[r][l]) {
                if (grid[r][l] == '1' && !visited[r][l]) {
                    searchLands(grid, new int[]{r, l});
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        char[][] chars = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numberOfIslands.numIslands(chars));
    }
}
