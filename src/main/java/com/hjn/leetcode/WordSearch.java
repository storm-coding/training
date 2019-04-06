package com.hjn.leetcode;

/**
 * 79. Word Search
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {
    /**
     * 题目意思： 给定一个二维数组board和一个单词word,判断单词word是不是在二维数组中
     * 这个单词可以由相邻单元格的字符组成，相邻可以是水平或者垂直的相邻，同一个单元格最多只能使用一次
     * <p>
     * 思路： 遍历二位数组，如果当前元素和给定word的第一位相等，
     * 则开始判断这个单词是不是在二位数组中。判断的过程是
     * 每个单词在二位数组中每次可能走的位置。如果在可能走的位置中能找到则继续往下寻找
     */
    private int[][] range = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = false;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) {
                        return true;
                    }
                    visited[i][j] = true;
                    boolean e = exist(board, word, new int[]{i, j}, 1);
                    visited[i][j] = false;
                    if(e){
                        return true;
                    }
                }

            }
        }

        return false;
    }

    /**
     * @param board
     * @param word
     * @param lastIndex 上一次需要访问的节点
     * @param curChar   当前需要匹配的位置在word中的位置
     * @return
     */
    private boolean exist(char[][] board, String word, int[] lastIndex, int curChar) {
        for (int n[] : range) {
            int r = lastIndex[0] + n[0];
            int l = lastIndex[1] + n[1];
            if (r >= 0 && r < board.length && l >= 0 && l < board[0].length && !visited[r][l]) {
                if (curChar < word.length() && board[r][l] == word.charAt(curChar)) {
                    visited[r][l] = true;
                    if (curChar == word.length() - 1) {
                        return true;
                    } else {
                        int[] newLast = new int[2];
                        newLast[0] = r;
                        newLast[1] = l;
                        boolean e = exist(board, word, newLast, curChar + 1);
                        visited[r][l] = false;
                        if(e){
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] arr = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };


        System.out.println(ws.exist(arr, "ABCCED"));
    }

}
