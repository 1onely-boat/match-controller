package com.competition.service;

import com.competition.entities.Teacher;

import java.util.List;


public interface TeacherService {

    List<Teacher> list(Teacher teacher);

    Teacher getTeacherById(Integer tid);

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

    int deleteTeacher(Integer tid);

    Teacher getTeacherByTeacherNumber(String teacherNumber);

}
