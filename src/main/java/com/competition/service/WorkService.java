package com.competition.service;

import com.competition.entities.Work;
import com.competition.entities.WorkList;

import java.util.List;


public interface WorkService {
    //获得工作量列表
    List<WorkList> getLists(WorkList workList);
    //通过ID获得比赛结果
    WorkList getWorkListById(Integer wid);
    //添加比赛结果
    int addWork(Work work);
    //修改比赛结果
    int updateWork(Work work);
    //通过ID删除比赛
    int deleteWorkById(Integer wid);
}
