package com.competition.service.impl;

import com.competition.entities.Student;
import com.competition.mapper.StudentMapper;
import com.competition.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> list(Student student) {
        return studentMapper.getLists(student);
    }

    @Override
    public Student getStudentById(Integer sid) {
        return studentMapper.getStudentById(sid);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(Integer sid) {
        return studentMapper.deleteStudentById(sid);
    }

}
