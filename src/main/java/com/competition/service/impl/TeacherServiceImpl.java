package com.competition.service.impl;

import com.competition.entities.Teacher;
import com.competition.mapper.TeacherMapper;
import com.competition.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherById(Integer tid) {
        return teacherMapper.getTeacherById(tid);
    }

    @Override
    public Teacher getTeacherByTeacherNumber(String teacherNumber) {
        return teacherMapper.getTeacherByTeacherNumber(teacherNumber);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(Integer tid) {
        return teacherMapper.deleteTeacherById(tid);
    }

    @Override
    public List<Teacher> list(Teacher teacher) {
        return teacherMapper.getLists(teacher);
    }
}
