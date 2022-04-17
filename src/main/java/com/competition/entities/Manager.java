package com.competition.entities;

import java.util.Date;

/**
 * @Des 管理员
 * @Author guyu
 * @Date 2020/7/11 22:50
 * @Param
 * @Return
 */

public class Manager {
    private int id;
    //登录名
    private String Username;
    //登录密码
    private String Password;
    //移动手机号
    private int Mobile;
    //管理员名字
    private String AdminName;
    //登录时间
    private Date LoginTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getMobile() {
        return Mobile;
    }

    public void setMobile(int mobile) {
        Mobile = mobile;
    }

    public String getAdminName() {
        return AdminName;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }

    public Date getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(Date loginTime) {
        LoginTime = loginTime;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Mobile=" + Mobile +
                ", AdminName='" + AdminName + '\'' +
                ", LoginTime=" + LoginTime +
                '}';
    }
}
