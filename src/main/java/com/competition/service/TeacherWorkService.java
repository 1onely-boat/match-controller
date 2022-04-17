package com.competition.service;

import com.competition.entities.TeacherWork;

import java.util.List;


public interface TeacherWorkService {

    List<TeacherWork> list(TeacherWork teacherWork);

    TeacherWork getTeacherWorkById(Integer wid);

    int addTeacherWork(TeacherWork teacherWork);

    int updateTeacherWork(TeacherWork teacherWork);

    int deleteTeacherWork(Integer wid);

}
