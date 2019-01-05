package com.hjn;

/**
 * Created by xiaoz on 2018/12/22.
 */
public class Matrix {
    /**
     * 杨辉三角的改版
     *
     * @param matrix
     * @return
     */
    public static boolean numIsExistMatrix(int[][] matrix, int num) {
        if (matrix == null) {
            return false;
        }

        int row = matrix.length - 1;
        int line = matrix[0].length - 1;
        // 从矩阵的右下角往左上角索搜，当行、列小于零或遇到正确值时搜索结束
        while (row >= 0 && line >= 0) {
            int temp = matrix[row][line];
            if (num > temp) {
                row--;
            }
            if (num < temp) {
                line--;
            }
            if (num == temp) {
                return true;
            }
        }
        return false;
    }
}
