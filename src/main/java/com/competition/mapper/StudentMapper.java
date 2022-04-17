package com.competition.mapper;

import com.competition.entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMapper {

    //获得学生列表
    List<Student> getLists(Student student);
    //通过id查找
    Student getStudentById(Integer sid);
    //添加学生
    int addStudent(Student student);
    //修改学生
    int updateStudent(Student student);
    //通过ID删除学生
    int deleteStudentById(Integer sid);
}
