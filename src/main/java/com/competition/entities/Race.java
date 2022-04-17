package com.competition.entities;

import java.util.Date;

/**
 * @Des 比赛信息
 * @Author guyu
 * @Date 2020/7/11 22:51
 * @Param
 * @Return
 */

public class Race {
    private int rid;
    //比赛名称
    private String raceName;
    //比赛级别
    private int raceLevel;
    //主办方
    private String raceMaster;
    //报名开始时间
    private Date beginTime;
    //报名结束时间
    private Date endTime;
    //比赛开始时间
    private Date raceBegintime;
    //比赛结束时间
    private Date raceEndtime;
    //比赛地点
    private String raceLocation;
    //比赛信息
    private String raceInfo;
    //比赛
    private String raceFile;
    //发布人ID
    private int updateId;
    //最后发布时间
    private Date updateTime;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    public String getRaceMaster() {
        return raceMaster;
    }

    public void setRaceMaster(String raceMaster) {
        this.raceMaster = raceMaster;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getRaceLocation() {
        return raceLocation;
    }

    public void setRaceLocation(String raceLocation) {
        this.raceLocation = raceLocation;
    }

    public String getRaceInfo() {
        return raceInfo;
    }

    public void setRaceInfo(String raceInfo) {
        this.raceInfo = raceInfo;
    }

    public String getRaceFile() {
        return raceFile;
    }

    public void setRaceFile(String raceFile) {
        this.raceFile = raceFile;
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
        return "Race{" +
                "rid=" + rid +
                ", raceName='" + raceName + '\'' +
                ", raceLevel='" + raceLevel + '\'' +
                ", raceMaster='" + raceMaster + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", raceBegintime=" + raceBegintime +
                ", raceEndtime=" + raceEndtime +
                ", raceLocation='" + raceLocation + '\'' +
                ", raceInfo='" + raceInfo + '\'' +
                ", raceFile='" + raceFile + '\'' +
                ", updateId=" + updateId +
                ", updateTime=" + updateTime +
                '}';
    }
}
