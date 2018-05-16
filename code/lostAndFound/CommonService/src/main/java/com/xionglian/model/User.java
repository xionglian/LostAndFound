package com.xionglian.model;

import java.util.Date;

public class User {
    private Integer id;

    private String loginName;

    private String username;

    private String password;

    private String tel;

    private String mail;

    private Byte sex;

    private String userImg;

    private Byte role;

    private String schoolLocation;

    private String secondSchool;

    private String userClass;

    private Date createTime;

    private Boolean isLogin;

    private Integer putLostNum;

    private Integer putFoundNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail == null ? null : mail.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    public Byte getRole() {
        return role;
    }

    public void setRole(Byte role) {
        this.role = role;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation == null ? null : schoolLocation.trim();
    }

    public String getSecondSchool() {
        return secondSchool;
    }

    public void setSecondSchool(String secondSchool) {
        this.secondSchool = secondSchool == null ? null : secondSchool.trim();
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass == null ? null : userClass.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Integer getPutLostNum() {
        return putLostNum;
    }

    public void setPutLostNum(Integer putLostNum) {
        this.putLostNum = putLostNum;
    }

    public Integer getPutFoundNum() {
        return putFoundNum;
    }

    public void setPutFoundNum(Integer putFoundNum) {
        this.putFoundNum = putFoundNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", mail='" + mail + '\'' +
                ", sex=" + sex +
                ", userImg='" + userImg + '\'' +
                ", role=" + role +
                ", schoolLocation='" + schoolLocation + '\'' +
                ", secondSchool='" + secondSchool + '\'' +
                ", userClass='" + userClass + '\'' +
                ", createTime=" + createTime +
                ", isLogin=" + isLogin +
                ", putLostNum=" + putLostNum +
                ", putFoundNum=" + putFoundNum +
                '}';
    }
}