package com.competition.entities;


public class PredictFinancialList extends PredictFinancial {
    //队伍名称
    private String teamName;
    //比赛名称
    private String raceName;

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
}
