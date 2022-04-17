package com.competition.mapper;

import com.competition.entities.Race;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RaceMapper {

    //获得比赛列表
    List<Race> getLists(Race race);
    //通过id查找
    Race getRaceById(Integer rid);
    //添加比赛
    int addRace(Race race);
    //修改比赛
    int updateRace(Race race);
    //通过ID删除比赛
    int deleteRaceById(Integer rid);
}
