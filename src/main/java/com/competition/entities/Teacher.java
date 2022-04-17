package com.competition.entities;

import java.util.Date;

/**
 * @Des 教师
 * @Author guyu
 * @Date 2020/7/11 22:51
 * @Param
 * @Return
 */

public class Teacher {
    private int tid;
    //教师名字
    private String teacherName;
    //教师性别
    private String teacherSex;
    //教师职位
    private String teacherProfession;
    //教师登录账号（工号）
    private int teacherNumber;
    //密码
    private String teacherPassword;
    //手机号
    private String teacherMobile;
    //教师工作量
    private float teacherWork;

    private int teacherStatus;
    //上次登录时间
    private Date loginTime;

    public Teacher() {

    }

    public Teacher(int tid, String teacherName, String teacherSex) {
        this.tid = tid;
        this.teacherName = teacherName;
        this.teacherSex = teacherSex;

    }


    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getTeacherProfession() {
        return teacherProfession;
    }

    public void setTeacherProfession(String teacherProfession) {
        this.teacherProfession = teacherProfession;
    }

    public int getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(int teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    public String getTeacherMobile() {
        return teacherMobile;
    }

    public void setTeacherMobile(String teacherMobile) {
        this.teacherMobile = teacherMobile;
    }

    public float getTeacherWork() {
        return teacherWork;
    }

    public void setTeacherWork(float teacherWork) {
        this.teacherWork = teacherWork;
    }

    public int getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(int teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", teacherProfession='" + teacherProfession + '\'' +
                ", teacherNumber=" + teacherNumber +
                ", teacherPassword='" + teacherPassword + '\'' +
                ", teacherMobile='" + teacherMobile + '\'' +
                ", teacherWork=" + teacherWork +
                ", teacherStatus='" + teacherStatus + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
