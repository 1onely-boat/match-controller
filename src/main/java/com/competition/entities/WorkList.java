package com.competition.entities;

public class WorkList extends Work {
    //指导老师
    private String teacherName;
    //比赛名字
    private String raceName;
    //比赛级别
    private int raceLevel;
    //队伍名字
    private String teamName;
    //教师工号
    private String teacherNumber;


    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public int getRaceLevel() {
        return raceLevel;
    }

    public void setRaceLevel(int raceLevel) {
        this.raceLevel = raceLevel;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }


    @Override
    public String toString() {
        return "WorkList{" +
                "teacherName='" + teacherName + '\'' +
                ", raceName='" + raceName + '\'' +
                ", raceLevel='" + raceLevel + '\'' +
                ", teamName='" + teamName + '\'' +
                ", teacherNumber='" + teacherNumber + '\'' +
                '}';
    }
}
