package com.competition.entities;


public class TeacherWork {
    private int wid;
    //教师id
    private int teacherId;
    //省级和国级获奖数量
    private int hProvince;
    //校级获奖数量
    private int hSchool;
    //三等奖及以上
    private int lPrize;
    //其他奖
    private int lOther;
    //团队级别
    private int fTeam;
    //考试级别
    private int fExam;
    //工作量
    private int otherNumber;
    //总的工作量
    private int totalNumber;

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

    public int gethProvince() {
        return hProvince;
    }

    public void sethProvince(int hProvince) {
        this.hProvince = hProvince;
    }

    public int gethSchool() {
        return hSchool;
    }

    public void sethSchool(int hSchool) {
        this.hSchool = hSchool;
    }

    public int getlPrize() {
        return lPrize;
    }

    public void setlPrize(int lPrize) {
        this.lPrize = lPrize;
    }

    public int getlOther() {
        return lOther;
    }

    public void setlOther(int lOther) {
        this.lOther = lOther;
    }

    public int getfTeam() {
        return fTeam;
    }

    public void setfTeam(int fTeam) {
        this.fTeam = fTeam;
    }

    public int getfExam() {
        return fExam;
    }

    public void setfExam(int fExam) {
        this.fExam = fExam;
    }

    public int getOtherNumber() {
        return otherNumber;
    }

    public void setOtherNumber(int otherNumber) {
        this.otherNumber = otherNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    @Override
    public String toString() {
        return "TeacherWork{" +
                "wid=" + wid +
                ", teacherId=" + teacherId +
                ", hProvince=" + hProvince +
                ", hSchool=" + hSchool +
                ", lPrize=" + lPrize +
                ", lOther=" + lOther +
                ", fTeam=" + fTeam +
                ", fExam=" + fExam +
                ", otherNumber=" + otherNumber +
                ", totalNumber=" + totalNumber +
                '}';
    }
}
