package com.competition.controller;

import com.competition.entities.Teacher;
import com.competition.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


//修改密码
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    TeacherService teacherService;

    //跳转到修改用户密码
    @ResponseBody
    @GetMapping("/user/pwd/{oldPwd}")
    public Boolean checkPwd(HttpSession session, @PathVariable("oldPwd") String oldPwd) {

        logger.info("旧密码-->" + oldPwd);
        //1.从session中获取user对象
        Teacher user = (Teacher) session.getAttribute("loginUser");
        if (user.getTeacherPassword().equals(oldPwd)) {
            //输入的旧密码正确
            return true;
        }
        return false;
    }

    @PostMapping("/user/pwd")
    public String updatePwd(HttpSession session, String password) {

        //1.从session中获取当前登录用户信息
        Teacher user = (Teacher) session.getAttribute("loginUser");
        //2.更新密码
        user.setTeacherPassword(password);
        //3.提交到数据库
        teacherService.updateTeacher(user);
        //4.注销重新登录
        return "redirect:/logout";
    }
}
