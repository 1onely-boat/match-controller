package com.competition.entities;

/**
 * @Des 获奖情况
 * @Author guyu
 * @Date 2020/7/11 22:49
 * @Param
 * @Return
 */
public class Award {

    private int aid;
    //比赛ID
    private int raceId;
    //队伍ID
    private int teamId;
    //第一导师ID
    private int firstTeacherid;
    //证书等级
    private String certificateLevel;
    //证书编号
    private String certificateNumber;
    //证书照片
    private String certificatePicture;
    //现场照片
    private String activityPicture;
    //是否获奖，0否1是
    private int ifAward;
    //获奖情况是否被管理员批准，0否1是
    private int ifApprove;


    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public int getFirstTeacherid() {
        return firstTeacherid;
    }

    public void setFirstTeacherid(int firstTeacherid) {
        this.firstTeacherid = firstTeacherid;
    }

    public String getCertificateLevel() {
        return certificateLevel;
    }

    public void setCertificateLevel(String certificateLevel) {
        this.certificateLevel = certificateLevel;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCertificatePicture() {
        return certificatePicture;
    }

    public void setCertificatePicture(String certificatePicture) {
        this.certificatePicture = certificatePicture;
    }

    public String getActivityPicture() {
        return activityPicture;
    }

    public void setActivityPicture(String activityPicture) {
        this.activityPicture = activityPicture;
    }

    public int getIfAward() {
        return ifAward;
    }

    public void setIfAward(int ifAward) {
        this.ifAward = ifAward;
    }

    public int getIfApprove() {
        return ifApprove;
    }

    public void setIfApprove(int ifApprove) {
        this.ifApprove = ifApprove;
    }
}
