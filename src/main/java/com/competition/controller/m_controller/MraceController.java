package com.competition.controller.m_controller;

import com.competition.entities.Race;
import com.competition.entities.Teacher;
import com.competition.service.RaceService;
import com.competition.service.TeamService;
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

//比赛管理
@Controller
public class MraceController {

    @Autowired
    RaceService raceService;
    @Autowired
    TeamService teamService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/mrace")
    public String lists(Map<String, Object> map, Race race, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //分页为12条一页
        PageHelper.startPage(pageNum, 12);

        List<Race> races = raceService.list(race);
        PageInfo<Race> pageInfo = new PageInfo<Race>(races);
        map.put("pageInfo", pageInfo);
        map.put("raceName", race.getRaceName());
        map.put("raceLevel", race.getRaceLevel());

        //跳转到比赛列表
        return "manager/race/list";
    }

    //查看比赛or修改比赛
    @GetMapping("/mrace/{rid}")
    public String view(@PathVariable("rid") Integer rid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {
        logger.info("查询" + rid + "的详细信息");
        Race race = raceService.getRaceById(rid);
        map.put("race", race);
        return "manager/race/" + type;
    }

    //修改比赛信息
    @PutMapping("/mrace")
    public String update(HttpSession httpSession, Race race) {

        Teacher loginUser = (Teacher) httpSession.getAttribute("loginUser");
        race.setUpdateId(loginUser.getTid());
        raceService.updateRace(race);
        return "redirect:/mrace";
    }

    //跳转到添加页面
    @GetMapping("/addrace")
    public String toAddPage(Model map) {

        return "manager/race/add";
    }

    //添加数据
    @PostMapping("/mrace")
    public String add(Race race, HttpSession session) {
        //添加人的id
        race.setUpdateId(((Teacher) session.getAttribute(("loginUser"))).getTid());
        logger.info("添加race的数据" + race);
        //保存数据操作
        raceService.addRace(race);
        return "redirect:/mrace";
    }

    //删除比赛数据
    @DeleteMapping("/mrace/{rid}")
    public String deleteBill(@PathVariable("rid") Integer rid) {
        raceService.deleteRace(rid);
        return "redirect:/mrace";
    }

}
