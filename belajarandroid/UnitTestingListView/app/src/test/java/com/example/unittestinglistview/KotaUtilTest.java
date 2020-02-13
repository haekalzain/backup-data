package com.example.unittestinglistview;

import com.example.unittestinglistview.util.KotaUtil;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class KotaUtilTest {

    @Test
    public void  testKotaKe1(){
        String actual= KotaUtil.listKota[1];
        String expected ="Jakarta Barat";
        assertEquals("Kota ke 1 failed",expected,actual);
    }

    @Test
    public void testKotaKe3(){
        String actual = KotaUtil.listKota[3];
        String expected ="Medan";
        assertEquals("Kota ke 3 Failed",expected,actual);
    }

}
