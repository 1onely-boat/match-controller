package com.competition.entities;

import java.util.Date;

public class TeamList extends Team {
    //比赛学生
    private String studentName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    //指导老师
    private String teacherName;
    //学生电话
    private String studentMobile;
    //比赛名字
    private String raceName;
    //比赛级别
    private String raceLevel;
    //比赛开始时间
    private Date raceBegintime;
    //比赛结束时间
    private Date raceEndtime;

    public String getRaceLevel() {
        return raceLevel;
    }

    public void setRaceLevel(String raceLevel) {
        this.raceLevel = raceLevel;
    }

    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public Date getRaceBegintime() {
        return raceBegintime;
    }

    public void setRaceBegintime(Date raceBegintime) {
        this.raceBegintime = raceBegintime;
    }

    public Date getRaceEndtime() {
        return raceEndtime;
    }

    public void setRaceEndtime(Date raceEndtime) {
        this.raceEndtime = raceEndtime;
    }

    @Override
    public String toString() {
        return "TeamList{" +
                "studentName='" + studentName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", studentMobile='" + studentMobile + '\'' +
                ", raceName='" + raceName + '\'' +
                ", raceLevel='" + raceLevel + '\'' +
                ", raceBegintime=" + raceBegintime +
                ", raceEndtime=" + raceEndtime +
                '}';
    }
}
