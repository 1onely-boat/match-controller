package com.competition.service.impl;

import com.competition.entities.Race;
import com.competition.mapper.RaceMapper;
import com.competition.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RaceServiceImpl implements RaceService {

    @Autowired
    RaceMapper raceMapper;

    @Override
    public List<Race> list(Race race) {
        return raceMapper.getLists(race);
    }

    @Override
    public Race getRaceById(Integer rid) {
        return raceMapper.getRaceById(rid);
    }

    @Override
    public int addRace(Race race) {
        return raceMapper.addRace(race);
    }

    @Override
    public int updateRace(Race race) {
        return raceMapper.updateRace(race);
    }

    @Override
    public int deleteRace(Integer rid) {
        return raceMapper.deleteRaceById(rid);
    }
}
