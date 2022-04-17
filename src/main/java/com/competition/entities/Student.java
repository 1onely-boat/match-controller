package com.competition.entities;

/**
 * @Des 学生
 * @Author guyu
 * @Date 2020/7/11 22:51
 * @Param
 * @Return
 */

public class Student {
    private Integer sid;
    //姓名
    private String studentName;
    //性别
    private String studentSex;
    //学生班级
    private String studentClass;
    //学生学号
    private String studentNumber;
    //电话
    private String studentMobile;
    //微信
    private String studentWechar;
    private Integer studentStatus;


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentWechar() {
        return studentWechar;
    }

    public void setStudentWechar(String studentWechar) {
        this.studentWechar = studentWechar;
    }

    public Integer getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(Integer studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", studentName='" + studentName + '\'' +
                ", studentSex='" + studentSex + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                ", studentWechar='" + studentWechar + '\'' +
                ", studentStatus=" + studentStatus +
                '}';
    }

    public Student() {
    }


}
