package com.competition.service.impl;

import com.competition.entities.Team;
import com.competition.entities.TeamList;
import com.competition.entities.Work;
import com.competition.mapper.TeamMapper;
import com.competition.mapper.WorkMapper;
import com.competition.service.TeamService;
import com.competition.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    TeamMapper teamMapper;

    @Override
    public List<TeamList> myList(TeamList teamList, Integer tid) {
        return teamMapper.getMyLists(teamList, tid);
    }

    @Override
    public List<TeamList> list(TeamList teamList) {
        return teamMapper.getLists(teamList);
    }

    @Override
    public TeamList getTeamById(Integer temid) {
        return teamMapper.getTeamById(temid);
    }

    @Autowired
    WorkMapper workMapper;
    @Override
    public int addTeam(Team team){
        int temid = teamMapper.addTeamList(team);
//        TeamList teamByName = teamMapper.getTeamByName(team.getTeamName());
//
//        Work work = new Work();
//        if(team.getTeamStatus()==1){
//        work.setStatus(1);
//        }else {
//        work.setStatus(0);
//        }
//        work.setTeamId(teamByName.getTemid());
//        work.setTeacherId(team.getTeacherId());
//        work.setRaceId(team.getRaceId());
//        workMapper.addWork(work);
        return temid;
    }

    @Override
    public int updateTeam(TeamList teamList) {
        return teamMapper.updateTeamList(teamList);
    }

    @Override
    public int deleteTeam(Integer temid) {
        teamMapper.deleteTeamById(temid);
        workMapper.deleteWorkById(temid);
        return 1;
    }
}
