package com.competition.mapper;

import com.competition.entities.Work;
import com.competition.entities.WorkList;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WorkMapper {

    //获得比赛结果列表
    List<WorkList> getLists(WorkList workList);
    //通过ID获得比赛结果
    WorkList getWorkListById(Integer wid);
    //添加比赛结果(Award)
    int addWork(Work work);
    //修改比赛结果
    int updateWork(Work Work);
    //通过name删除比赛
    int deleteWorkById(Integer wid);

}
