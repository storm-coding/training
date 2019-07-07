package com.hjn;

import org.junit.Test;

import static org.junit.Assert.*;


public class IpUtilTest {
    @Test
    public void test_ipToInt_normal_zero()  {
        assertEquals(0, IpUtil.ipToInt("0.0.0.0"));
    }

    @Test
    public void test_ipToInt_normal()  {
        assertEquals(2147483660L, IpUtil.ipToInt("128.0.0.12"));
    }

    @Test
    public void test_ipToInt_partNum_more255() {
        try {
             IpUtil.ipToInt("256.125.1287.125");
        } catch (NumberFormatException e) {
            assertEquals("ip format error, ip part is more 255, ipPart =256",e.getMessage());
        }
    }

    @Test
    public void test_ipToInt_partLen_less_4() {
        try {
            IpUtil.ipToInt("1.12.1");
        } catch (NumberFormatException e) {
            assertEquals("ip format error ip=1.12.1",e.getMessage());
        }
    }

    @Test
    public void test_ipToInt_ip_has_special_character() {
        try {
            IpUtil.ipToInt("a.12.c");
        } catch (IllegalArgumentException e) {
            assertEquals("ip format error ipPart =a",e.getMessage());
        }
    }

    @Test
    public void test_ipToStr_normal()  {
        assertEquals("128.0.0.12",IpUtil.ipToStr(2147483660L));
    }

    @Test
    public void test_ipToStr_ip_less_zero()  {
        try {
            IpUtil.ipToStr(-1);
        }catch (IllegalArgumentException e){
            assertEquals("ip is less 0 or more 4294967295L",e.getMessage());
        }
    }

}