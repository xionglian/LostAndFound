package com.xionglian.common.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by  xionglian on 2018-05-09.
 */
public class Md5Test {
    @Test
    public void testMd5()throws Exception{
        System.out.print(Md5.getMD5Str("123"));
    }
}