package com.competition.controller.m_controller;

import com.competition.entities.*;
import com.competition.service.RaceService;
import com.competition.service.StudentService;
import com.competition.service.TeacherService;
import com.competition.service.TeamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//队伍管理
@Controller
public class MteamController {

    @Autowired
    TeamService teamService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;
    @Autowired
    RaceService raceService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/team")
    public String list(Map<String, Object> map, TeamList teamList, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        PageHelper.startPage(pageNum, 12);
        List<TeamList> lists = teamService.list(teamList);
        PageInfo<TeamList> pageInfo = new PageInfo<TeamList>(lists);
        map.put("pageInfo", pageInfo);
        map.put("teamName", teamList.getTeamName());
        map.put("raceName", teamList.getRaceName());
        logger.info("pageInfo--> " + pageInfo);
        //跳转到比赛列表
        return "manager/team/list";
    }

    /*
     * 进入查看详情页面
     * */
    @GetMapping("/team/{temid}")
    public String view(@PathVariable("temid") Integer temid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {

        logger.info("查询" + temid + "的详细信息");
        TeamList teamById = teamService.getTeamById(temid);
        //修改时才进行查找
        if ("update".equals(type)) {
            //添加业务
        }
        map.put("student", teamById);
        return "manager/team/" + type;
    }
}
