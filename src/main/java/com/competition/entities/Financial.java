package com.competition.entities;

/**
 * @Des 经费
 * @Author guyu
 * @Date 2020/7/11 22:52
 * @Param
 * @Return
 */

public class Financial {
    private int fid;
    //预算数据id
    private int preid;
    //队伍ID
    private int teamId;
    //比赛id
    private int raceId;
    //报名费
    private float paymentFee;
    //差旅费
    private float carFee;
    //住宿费
    private float roomFee;
    //总费用
    private float totalFee;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }


    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public float getPaymentFee() {
        return paymentFee;
    }

    public void setPaymentFee(float paymentFee) {
        this.paymentFee = paymentFee;
    }

    public float getCarFee() {
        return carFee;
    }

    public void setCarFee(float carFee) {
        this.carFee = carFee;
    }

    public float getRoomFee() {
        return roomFee;
    }

    public void setRoomFee(float roomFee) {
        this.roomFee = roomFee;
    }

    public float getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(float totalFee) {
        this.totalFee = totalFee;
    }

    public int getPreid() {
        return preid;
    }

    public void setPreid(int preid) {
        this.preid = preid;
    }

    @Override
    public String toString() {
        return "Financial{" +
                "fid=" + fid +
                ", preid=" + preid +
                ", teamId=" + teamId +
                ", raceId=" + raceId +
                ", paymentFee=" + paymentFee +
                ", carFee=" + carFee +
                ", roomFee=" + roomFee +
                ", totalFee=" + totalFee +
                '}';
    }
}
