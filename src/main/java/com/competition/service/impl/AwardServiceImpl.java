package com.competition.service.impl;

import com.competition.entities.Award;
import com.competition.entities.AwardList;
import com.competition.mapper.AwardMapper;
import com.competition.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    AwardMapper awardMapper;

    @Override
    public List<AwardList> getLists(AwardList awardList) {
        return awardMapper.getLists(awardList);
    }

    @Override
    public AwardList getAwardListById(Integer teid) {
        return awardMapper.getAwardListById(teid);
    }

    @Override
    public int addAwardList(Award award) {
        return awardMapper.addAwardList(award);
    }

    @Override
    public int updateAwardList(Award award) {
        return awardMapper.updateAwardList(award);
    }

    @Override
    public int deleteAwardListById(Integer teid) {
        return awardMapper.deleteAwardListById(teid);
    }
}
