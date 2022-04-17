package com.competition.controller.t_controller;

import com.competition.entities.Race;
import com.competition.service.RaceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RaceController {


    @Autowired
    RaceService raceService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/trace")
    public String list(Map<String, Object> map, Race race, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //分页为12条一页
        PageHelper.startPage(pageNum, 12);

        List<Race> races = raceService.list(race);
        PageInfo<Race> pageInfo = new PageInfo<Race>(races);
        map.put("pageInfo", pageInfo);
        map.put("raceName", race.getRaceName());
        map.put("raceLevel", race.getRaceLevel());
        //跳转到学生列表

        return "teacher/race/list";
    }

    /*
     * 进入查看详情页面
     * */
    @GetMapping("/trace/{rid}")
    public String view(@PathVariable("rid") Integer rid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {
        logger.info("查询" + rid + "的详细信息");
        Race race = raceService.getRaceById(rid);
        map.put("race", race);
        return "teacher/race/" + type;
    }
}
