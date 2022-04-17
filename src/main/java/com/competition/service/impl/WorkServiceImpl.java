package com.competition.service.impl;

import com.competition.entities.Work;
import com.competition.entities.WorkList;
import com.competition.mapper.WorkMapper;
import com.competition.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkServiceImpl implements WorkService {

    @Autowired
    WorkMapper workMapper;

    @Override
    public List<WorkList> getLists(WorkList workList) {
        return workMapper.getLists(workList);
    }

    @Override
    public WorkList getWorkListById(Integer wid) {
        return workMapper.getWorkListById(wid);
    }

    @Override
    public int addWork(Work work) {
        return workMapper.addWork(work);
    }

    @Override
    public int updateWork(Work work) {
        return workMapper.updateWork(work);
    }

    @Override
    public int deleteWorkById(Integer wid) {
        return workMapper.deleteWorkById(wid);
    }
}
