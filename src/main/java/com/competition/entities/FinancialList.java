package com.competition.entities;


public class FinancialList extends Financial{
    //预测报名费
    private float paymentPrice;
    //预测车旅费
    private float carPrice;
    //预测住宿费
    private float roomPrice;
    //预测总资金
    private float totalPrice;
    //队伍名称
    private String teamName;
    //比赛名称
    private String raceName;

    public float getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(float paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    @Override
    public String toString() {
        return "FinancialList{" +
                "paymentPrice=" + paymentPrice +
                ", carPrice=" + carPrice +
                ", roomPrice=" + roomPrice +
                ", totalPrice=" + totalPrice +
                ", teamName='" + teamName + '\'' +
                ", raceName='" + raceName + '\'' +
                '}';
    }
}
