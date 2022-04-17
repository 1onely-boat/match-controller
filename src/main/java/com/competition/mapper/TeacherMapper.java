package com.competition.mapper;

import com.competition.entities.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherMapper {

    //获得教师列表
    List<Teacher> getLists(Teacher teacher);
    //通过id查找
    Teacher getTeacherById(Integer id);
    //通过工号查找
    Teacher getTeacherByTeacherNumber(String number);
    //添加教师
    int addTeacher(Teacher teacher);
    //修改教师
    int updateTeacher(Teacher teacher);
    //通过ID删除教师
    int deleteTeacherById(Integer id);
}
