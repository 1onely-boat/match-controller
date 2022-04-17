package com.competition.controller.m_controller;

import com.competition.entities.Teacher;
import com.competition.entities.WorkList;
import com.competition.service.TeacherService;
import com.competition.service.WorkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


//查看教师工作量
@Controller
public class WorkController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    WorkService workService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/works")
    public String list(Map<String, Object> map, WorkList workList, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //分页为8条一页
        PageHelper.startPage(pageNum, 8);
        List<WorkList> list = workService.getLists(workList);
        PageInfo<WorkList> pageInfo = new PageInfo<WorkList>(list);
        map.put("pageInfo", pageInfo);
        map.put("teacherName", workList.getTeacherName());
        return "manager/work/list";
    }

    @GetMapping("/searchworks")
    public String searchlist(Map<String, Object> map, WorkList workList) {
        List<WorkList> list = workService.getLists(workList);
        float num = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRaceLevel() == 1) {
                num += 0.8;
            }
            if (list.get(i).getRaceLevel() > 1) {
                num += 1;
            }
        }

        map.put("total", num);
        map.put("totalnum", list.size());
        map.put("pageInfo", list);
        if (list.size() > 0) {
            map.put("teacherName", list.get(0).getTeacherName());
            map.put("teacherNumber", list.get(0).getTeacherNumber());
        } else {
            map.put("teacherName", workList.getTeacherName());
        }

        return "manager/work/searchlists";
    }

    //查看
    @GetMapping("/work/{wid}")
    public String view(@PathVariable("wid") Integer wid, @RequestParam(value = "type", defaultValue = "view") String type, Model model) {

        WorkList teacherById = workService.getWorkListById(wid);

        if ("update".equals(type)) {
            //
        }
        model.addAttribute("work", teacherById);
        return "manager/work/" + type;
    }


    //删除工作量
    @DeleteMapping("/work/{wid}")
    public String deleteWork(@PathVariable("wid") Integer wid) {
        workService.deleteWorkById(wid);
        return "redirect:/works";
    }

    /*
     * 教师查看自己的细节
     * */
    @GetMapping("/teacher/showDetails")
    public String showDetails(Map<String, Object> map, HttpSession session) {
        WorkList workList = new WorkList();
        Teacher teacher = (Teacher) session.getAttribute("loginUser");
        workList.setTeacherName(teacher.getTeacherName());
        List<WorkList> list = workService.getLists(workList);
        float num = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRaceLevel() == 1) {
                num += 0.8;
            }
            if (list.get(i).getRaceLevel() > 1) {
                num += 1;
            }
        }

        map.put("total", num);
        map.put("totalnum", list.size());
        map.put("pageInfo", list);

        map.put("teacher", teacher);

        return "teacher/detail/details";
    }
}
