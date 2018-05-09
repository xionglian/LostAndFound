package com.xionglian.common.util;

import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lenovo on 2018/4/8.
 */
public class IdCreateUtil
{
    public IdCreateUtil()
    {

    }

    /**
     * 获得一个UUID
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }

}
