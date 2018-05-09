package com.xionglian.common.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import java.io.Serializable;
/**
 * Created by lenovo on 2018/3/31.
 * 统一请求
 */
@Component
@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ResMessage implements Serializable {
    private String result;

    private Object data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
