package com.hjn;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by xiaoz on 2018/12/22.
 */
public class CompareTwoStringTest {
    @Test
    public void test_TwoStringCompriseIsEqual_All_Null() {
        assertTrue(CompareTwoString.twoStringCompriseIsEqual(null,null));
    }

    @Test
    public void test_TwoStringCompriseIsEqual_Single_Null() {
        assertFalse(CompareTwoString.twoStringCompriseIsEqual(null,"test_string"));
    }

    @Test
    public void test_TwoStringCompriseIsEqual_Length_Not_Equal() {
        assertFalse(CompareTwoString.twoStringCompriseIsEqual("test_length","test_length11"));
    }

    @Test
    public void test_TwoStringCompriseIsEqual_Normal() {
        assertTrue(CompareTwoString.twoStringCompriseIsEqual("acbbcca","acbcbac"));
    }

    @Test
    public void test_TwoStringCompriseIsEqual_Has_Diff_Key() {
        assertFalse(CompareTwoString.twoStringCompriseIsEqual("acbbcca","aabbbbb"));
    }

    @Test
    public void test_TwoStringCompriseIsEqual_Key_Value_NOt_Equal() {
        assertFalse(CompareTwoString.twoStringCompriseIsEqual("acbbcca","1231122"));
    }
}