package com.xionglian.common.request;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by lenovo on 2018/3/31.
 * 统一请求
 */
@Component
public class ReqMessage implements Serializable
{
    private String sid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
