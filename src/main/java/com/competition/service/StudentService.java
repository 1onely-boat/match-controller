package com.competition.service;

import com.competition.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> list(Student student);

    Student getStudentById(Integer tid);

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(Integer tid);

}
