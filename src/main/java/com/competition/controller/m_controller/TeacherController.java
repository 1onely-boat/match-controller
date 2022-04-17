package com.competition.controller.m_controller;

import com.competition.entities.Teacher;
import com.competition.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


//教师管理
@Controller
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/teacherManager")
    public String list(Map<String, Object> map, Teacher teacher, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //分页为12条一页
        PageHelper.startPage(pageNum, 12);
        List<Teacher> list = teacherService.list(teacher);
        PageInfo<Teacher> pageInfo = new PageInfo<Teacher>(list);
        map.put("pageInfo", pageInfo);
        map.put("teacherName", teacher.getTeacherName());
        map.put("teacherMobile", teacher.getTeacherMobile());

        return "manager/teacher/list";
    }

    //查看教师
    @GetMapping("/teacherManager/{tid}")
    public String view(@PathVariable("tid") Integer tid, @RequestParam(value = "type", defaultValue = "view") String type, Model model) {
        Teacher teacherById = teacherService.getTeacherById(tid);
        if ("update".equals(type)) {
            //add
        }
        model.addAttribute("teacher", teacherById);
        return "manager/teacher/" + type;
    }

    /*
     * 修改教师
     * */
    @PutMapping("/teacherManager")
    public String update(Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return "redirect:/teacherManager";
    }
    /*
     * 跳转到添加数据
     * */

    @GetMapping("/addTeacher")
    public String toAddTeacher() {
        return "manager/teacher/add";
    }

    //添加数据
    @PostMapping("/addteacher")
    public String addTeacher(Teacher teacher) {
        teacherService.addTeacher(teacher);
        logger.info("添加教师");
        return "redirect:/teacherManager";
    }

    //删除教师
    @DeleteMapping("/teacherManager/{tid}")
    public String deleteTeacher(@PathVariable("tid") Integer tid) {
        teacherService.deleteTeacher(tid);
        return "redirect:/teacherManager";
    }
}
