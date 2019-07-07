package com.hjn;

import org.junit.Test;
import org.mockito.internal.matchers.Null;

import static org.junit.Assert.*;


public class TopKTest {

    TopK topK = new TopK();

    @Test
    public void test_topn_normal() throws Exception {
        long[] result = topK.topn(new long[][] {{1, 2, 3}, {7, 8, 9}, {4, 5, 6} } , 5);
        long[] expect = {5,6,7,8,9};
        assertArrayEquals(expect,result);
    }

    @Test
    public void test_topn_normal_has_order() throws Exception {
        long[] result = topK.topn(new long[][] {{1, 2, 3},  {4, 5, 6},{7, 8, 9} } , 5);
        long[] expect = {5,6,7,8,9};
        assertArrayEquals(expect,result);
    }

    @Test
    public void test_one_arr() throws Exception {
        long[] result = topK.topn(new long[][] {{1}} , 1);
        long[] expect = {1};
        assertArrayEquals(expect,result);
    }

    @Test
    public void test_arr_element_less_k() throws Exception {
        try{
            topK.topn(new long[][] {{1}} , 2);
        }catch (RuntimeException e){
            assertEquals("array`s element is less k", e.getMessage());
        }
    }

    @Test
    public void test_arr_is_empty() throws Exception {
        try{
            topK.topn(new long[][] {} , 2);
        }catch (NullPointerException e){
            assertEquals("array is null or empty", e.getMessage());
        }
    }

}