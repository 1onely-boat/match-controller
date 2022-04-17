package com.competition.entities;

import java.util.Date;

/**
 * @Des 团队
 * @Author guyu
 * @Date 2020/7/11 22:52
 * @Param
 * @Return
 */
public class Team {
    private Integer temid;
    private String teamName;
    private int raceId;
    private String studentId;
    private String productionName;
    private String productionInfo;
    private int teacherId;
    private int teamStatus;
    private int updateId;
    private Date updateTime;

    public Integer getTemid() {
        return temid;
    }

    public void setTemid(Integer temid) {
        this.temid = temid;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProductionName() {
        return productionName;
    }

    public void setProductionName(String productionName) {
        this.productionName = productionName;
    }

    public String getProductionInfo() {
        return productionInfo;
    }

    public void setProductionInfo(String productionInfo) {
        this.productionInfo = productionInfo;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(int teamStatus) {
        this.teamStatus = teamStatus;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Team{" +
                "temid=" + temid +
                ", teamName='" + teamName + '\'' +
                ", raceId=" + raceId +
                ", studentId='" + studentId + '\'' +
                ", productionName='" + productionName + '\'' +
                ", productionInfo='" + productionInfo + '\'' +
                ", teacherId=" + teacherId +
                ", teamStatus='" + teamStatus + '\'' +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                '}';
    }
}
