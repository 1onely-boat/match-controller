package com.competition.controller;

import com.competition.entities.Teacher;
import com.competition.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

//登录
@Controller
public class LoginController {


    @Autowired
    TeacherService teacherService;

    /*
     * @param
     * username:教师工号
     * password:密码
     * */
    @PostMapping("/login")
    public String login(HttpSession session, String username, String password, String check, Map<String, Object> map) {

        //判断用户名不为空，且不为空
        //数据库中数据写在前边，传入的数据写在后面，防止出现空指针

        if (!(StringUtils.isEmpty(username)) && !StringUtils.isEmpty(password)) {
            //登录成功
            //重定向：可以重定向到任意一个请求中(包括其他项目)，地址拦会自动转变 (防止重复提交表单)

            Teacher user = teacherService.getTeacherByTeacherNumber(username);
            if (user != null && user.getTeacherPassword().equals(password)) {
                session.setAttribute("loginUser", user);

                /*
                 * @param
                 * cheaked:
                 * 1  0表示teacher
                 * 2  表示manager
                 *    默认是教师端
                 **/
                if (user.getTeacherStatus() == 1) {
                    return "redirect:/manager.html";
                }
                if (user.getTeacherStatus() == 0) {
                    return "redirect:/teacher.html";
                }
            }

        }
        //登录失败
        map.put("msg", "用户名或密码错误");

        return "main/login";
    }

    //跳转到修改密码
    @GetMapping("/password")
    public String updatePassword() {
        return "teacher/password";
    }


    //退出登录
    @GetMapping("/logout")
    public String logOut(HttpSession session) {

        // 1，清空session中用户信息，2注销session
        session.removeAttribute("loginUser");
        session.invalidate(); //session无效
        //重定向  //系统springMvcConfigure 中会自动跳转到 main/login
        return "redirect:/index.html";
    }

}
