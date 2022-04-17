package com.competition.service;

import com.competition.entities.Race;

import java.util.List;

/**
 * @program: project
 * @description  比赛service
 * @author: tomsen
 * @create: 2020-04
 **/
public interface RaceService {

    List<Race> list(Race race);

    Race getRaceById(Integer rid);

    int addRace(Race race);

    int updateRace(Race race);

    int deleteRace(Integer rid);

}
