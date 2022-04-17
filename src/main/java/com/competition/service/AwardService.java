package com.competition.service;

import com.competition.entities.Award;
import com.competition.entities.AwardList;

import java.util.List;

public interface AwardService {
    //获得比赛结果列表
    List<AwardList> getLists(AwardList awardList);
    //通过ID获得比赛结果
    AwardList getAwardListById(Integer teid);
    //添加比赛结果
    int addAwardList(Award award);
    //修改比赛结果
    int updateAwardList(Award award);
    //通过ID删除比赛
    int deleteAwardListById(Integer rid);
}
