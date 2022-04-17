package com.competition.mapper;

import com.competition.entities.Award;
import com.competition.entities.AwardList;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AwardMapper {

    //获得比赛结果列表
    List<AwardList> getLists(AwardList awardList);
    //通过ID获得比赛结果
    AwardList getAwardListById(Integer teid);
    //添加比赛结果(Award)
    int addAwardList(Award award);
    //修改比赛结果
    int updateAwardList(Award award);
    //通过ID删除比赛
    int deleteAwardListById(Integer rid);

}
