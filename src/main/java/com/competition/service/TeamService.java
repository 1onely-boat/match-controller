package com.competition.service;

import com.competition.entities.Team;
import com.competition.entities.TeamList;

import java.util.List;


public interface TeamService {

    List<TeamList> myList(TeamList teamList, Integer tid);

    List<TeamList> list(TeamList teamList);

    TeamList getTeamById(Integer temid);

    //int addTeam(TeamList teamList);
    int addTeam(Team team) throws Exception;

    int updateTeam(TeamList teamList);

    int deleteTeam(Integer temid);

}
