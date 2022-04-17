package com.competition.mapper;

import com.competition.entities.TeacherWork;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeacherWorkMapper {

    //获得教师列表
    List<TeacherWork> getLists(TeacherWork teacherWork);

    //通过id查找
    TeacherWork getTeacherWorkById(Integer wid);

    //添加教师比赛结果
    int addTeacherWork(TeacherWork teacherWork);

    //修改教师比赛结果
    int updateTeacherWork(TeacherWork teacherWork);

    //通过ID删除教师比赛结果
    int deleteTeacherWorkById(Integer wid);
}
