package com.competition.entities;

public class Work {
    private int wid;
    private int teacherId;
    private int raceId;
    private int teamId;
    private int status;
    private String totalWork;

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTotalWork() {
        return totalWork;
    }

    public void setTotalWork(String totalWork) {
        this.totalWork = totalWork;
    }

    @Override
    public String toString() {
        return "Work{" +
                "wid=" + wid +
                ", teacherId=" + teacherId +
                ", raceId=" + raceId +
                ", teamId=" + teamId +
                ", status=" + status +
                ", totalWork='" + totalWork + '\'' +
                '}';
    }
}
