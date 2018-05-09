package com.xionglian.common.util;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * Created by lenovo on 2018/4/8.
 */
public class LogIdUtil extends ClassicConverter {


    @Override
    public String convert(ILoggingEvent event) {
        return getLogId();
    }

    public static String getLogId()
    {
        String traceId = (String)logId.get();
        if(traceId == null || traceId.length() == 0)
        {
            traceId = IdCreateUtil.getUUID();
            setLogId(traceId);
        }
        return traceId;
    }

    public static void setLogId(String traceId)
    {
        logId.set(traceId);
    }

    private static final ThreadLocal logId = new ThreadLocal();
}
