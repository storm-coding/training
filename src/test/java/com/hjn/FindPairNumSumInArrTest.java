package com.hjn;

import org.junit.Test;

import static org.junit.Assert.*;


public class FindPairNumSumInArrTest {

    FindPairNumSumInArr findTarget = new FindPairNumSumInArr();

    @Test
    public void test_find_exit() {
        assertTrue(findTarget.find(new int[]{1, 2, 3, 5}, 8));
    }

    @Test
    public void test_find_not_exit_by_same_element() {
        assertFalse(findTarget.find(new int[]{1, 4, 5}, 8));
    }

    @Test
    public void test_find_not_exit_by_same_element_head() {
        assertFalse(findTarget.find(new int[]{4, 5, 8}, 8));
    }

    @Test
    public void test_find_not_exit_by_same_element_end() {
        assertFalse(findTarget.find(new int[]{1,2,4}, 8));
    }

    @Test
    public void test_find_not_exit_by_same_value_element() {
        assertTrue(findTarget.find(new int[]{1,2,4,4}, 8));
    }

    @Test
    public void test_find_has_sane_element() {
        assertTrue(findTarget.find(new int[]{1, 2, 2, 3, 3, 5}, 8));
    }

    @Test
    public void test_find_not_exit() {
        assertFalse(findTarget.find(new int[]{1, 2, 3, 9}, 8));
    }

    @Test
    public void test_find_single_element() {
        assertFalse(findTarget.find(new int[]{8}, 8));
    }

    @Test
    public void test_nums_isNull() {
        assertFalse(findTarget.find(null, 8));
    }

    @Test
    public void test_nums_isEmpty() {
        assertFalse(findTarget.find(new int[]{}, 8));
    }

}