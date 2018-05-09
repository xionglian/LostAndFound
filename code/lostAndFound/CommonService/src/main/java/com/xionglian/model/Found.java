package com.xionglian.model;

import java.util.Date;

public class Found {
    private Integer id;

    private String title;

    private Integer releaseUserId;

    private Integer confirmFoundUserId;

    private String linkName;

    private String linkPhone;

    private String goodType;

    private String goodName;

    private String foundAddress;

    private String foundAddressDetail;

    private Date foundTime;

    private Date createTime;

    private String descriptionDetail;

    private String keyWord01;

    private String keyWord02;

    private String keyWord03;

    private Byte state;

    private Date confirmTime;

    private String pictureUrl;

    private Integer clickNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getReleaseUserId() {
        return releaseUserId;
    }

    public void setReleaseUserId(Integer releaseUserId) {
        this.releaseUserId = releaseUserId;
    }

    public Integer getConfirmFoundUserId() {
        return confirmFoundUserId;
    }

    public void setConfirmFoundUserId(Integer confirmFoundUserId) {
        this.confirmFoundUserId = confirmFoundUserId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName == null ? null : linkName.trim();
    }

    public String getLinkPhone() {
        return linkPhone;
    }

    public void setLinkPhone(String linkPhone) {
        this.linkPhone = linkPhone == null ? null : linkPhone.trim();
    }

    public String getGoodType() {
        return goodType;
    }

    public void setGoodType(String goodType) {
        this.goodType = goodType == null ? null : goodType.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getFoundAddress() {
        return foundAddress;
    }

    public void setFoundAddress(String foundAddress) {
        this.foundAddress = foundAddress == null ? null : foundAddress.trim();
    }

    public String getFoundAddressDetail() {
        return foundAddressDetail;
    }

    public void setFoundAddressDetail(String foundAddressDetail) {
        this.foundAddressDetail = foundAddressDetail == null ? null : foundAddressDetail.trim();
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail == null ? null : descriptionDetail.trim();
    }

    public String getKeyWord01() {
        return keyWord01;
    }

    public void setKeyWord01(String keyWord01) {
        this.keyWord01 = keyWord01 == null ? null : keyWord01.trim();
    }

    public String getKeyWord02() {
        return keyWord02;
    }

    public void setKeyWord02(String keyWord02) {
        this.keyWord02 = keyWord02 == null ? null : keyWord02.trim();
    }

    public String getKeyWord03() {
        return keyWord03;
    }

    public void setKeyWord03(String keyWord03) {
        this.keyWord03 = keyWord03 == null ? null : keyWord03.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }
}