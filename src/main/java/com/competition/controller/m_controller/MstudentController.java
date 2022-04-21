package com.competition.controller.m_controller;

import com.competition.entities.Student;
import com.competition.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


//学生管理
@Controller
public class MstudentController {

    @Autowired
    StudentService studentService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/mstudentManager")
    public String mlist(Map<String, Object> map, Student student, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //分页为12条一页
        PageHelper.startPage(pageNum, 12);
        List<Student> students = studentService.list(student);
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);
        map.put("pageInfo", pageInfo);
        map.put("studentName", student.getStudentName());
        map.put("studentClass", student.getStudentClass());
        //跳转到学生列表
        return "manager/student/list";
    }

    /*
     * 进入查看详情页面
     * */
    @GetMapping("/mstudent/{sid}")
    public String views(@PathVariable("sid") Integer sid, Map<String, Object> map,
                        @RequestParam(value = "type", defaultValue = "view") String type) {
        logger.info("查询" + sid + "的详细信息");
        Student student = studentService.getStudentById(sid);
        //修改时才进行查找
        map.put("student", student);

        return "manager/student/" + type;
    }

    //修改学生信息
    @PutMapping("/student")
    public String update(Student student) {

        studentService.updateStudent(student);
        return "redirect:/mstudentManager";
    }

    //跳转到添加页面
    @GetMapping("/addstudent")
    public String toAddPage(Map<String, Object> map) {

        return "teacher/student/add";
    }

    //添加数据
    @PostMapping("/student")
    public String add(Student student) {

        logger.info("添加student的数据" + student);
        //保存数据操作
        studentService.addStudent(student);
        return "redirect:/mstudentManager";
    }

    //删除数据
    @DeleteMapping("/student/{sid}")
    public String deleteBill(@PathVariable("sid") Integer sid) {
        studentService.deleteStudent(sid);
        return "redirect:/mstudentManager";
    }
}
