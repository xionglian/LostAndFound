package com.xionglian.model;

import java.util.Date;

public class PushMessage {
    private Integer id;

    private Integer userId;

    private Date receiveTime;

    private String informDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getInformDetail() {
        return informDetail;
    }

    public void setInformDetail(String informDetail) {
        this.informDetail = informDetail == null ? null : informDetail.trim();
    }
}