package com.competition.service.impl;

import com.competition.entities.TeacherWork;
import com.competition.mapper.TeacherWorkMapper;
import com.competition.service.TeacherWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherWorkServiceImpl implements TeacherWorkService {
    @Autowired
    TeacherWorkMapper teacherWorkMapper;
    @Override
    public List<TeacherWork> list(TeacherWork teacherWork) {
        return teacherWorkMapper.getLists(teacherWork);
    }

    @Override
    public TeacherWork getTeacherWorkById(Integer wid) {
        return teacherWorkMapper.getTeacherWorkById(wid);
    }

    @Override
    public int addTeacherWork(TeacherWork teacherWork) {
        return teacherWorkMapper.addTeacherWork(teacherWork);
    }

    @Override
    public int updateTeacherWork(TeacherWork teacherWork) {
        return teacherWorkMapper.updateTeacherWork(teacherWork);
    }

    @Override
    public int deleteTeacherWork(Integer wid) {
        return teacherWorkMapper.deleteTeacherWorkById(wid);
    }
}
