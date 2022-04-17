package com.competition.mapper;

import com.competition.entities.Team;
import com.competition.entities.TeamList;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamMapper {

    //获取当前老师所带队伍列表
    List<TeamList> getMyLists(TeamList teamList, Integer tid);

    //获得队伍列表
    List<TeamList> getLists(TeamList teamList);
    //通过id查找
    TeamList getTeamById(Integer temid);
    //通过name查找
    TeamList getTeamByName(String name);
    //添加队伍
    //int addTeamList(TeamList teamList);
    int addTeamList(Team team);
    //修改队伍
    int updateTeamList(TeamList teamList);
    //通过ID删除队伍
    int deleteTeamById(Integer temid);
}
