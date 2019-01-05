package com.hjn;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by xiaoz on 2018/12/22.
 */
public class MatrixTest {

    int[][] testArr;
    @Before
    public void setUp() throws Exception {
        testArr = new int[][]{{7, 8, 9, 10}, {5, 7, 8, 9}};
    }

    @Test
    public void test_NumIsExistMatrix_Matrix_Is_Null() {
        assertFalse(Matrix.numIsExistMatrix(null,1));
    }

    @Test
    public void test_NumIsExistMatrix_Matrix_Normal_True() {
        assertTrue(Matrix.numIsExistMatrix(testArr ,5));
    }

    @Test
    public void test_NumIsExistMatrix_Matrix_Normal_False() {
        assertFalse(Matrix.numIsExistMatrix(testArr ,100));
    }
}