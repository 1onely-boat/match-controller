package com.competition.controller.t_controller;

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

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Controller
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;
    @Autowired
    RaceService raceService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/teams")
    public String list(HttpSession session, Map<String, Object> map, TeamList teamList, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        Teacher loginUser = (Teacher)session.getAttribute("loginUser");

        PageHelper.startPage(pageNum, 12);

        List<TeamList> lists = teamService.myList(teamList, loginUser.getTid());
        PageInfo<TeamList> pageInfo = new PageInfo<TeamList>(lists);
        map.put("pageInfo", pageInfo);
        map.put("teamName", teamList.getTeamName());
        map.put("raceName", teamList.getRaceName());
        logger.info("pageInfo--> " + pageInfo);
        //跳转到比赛列表
        return "teacher/team/list";
    }

    /*
     * 进入查看详情页面
     * */
    @GetMapping("/teams/{temid}")
    public String view(@PathVariable("temid") Integer temid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {

        logger.info("查询" + temid + "的详细信息");
        TeamList teamById = teamService.getTeamById(temid);
        //修改时才进行查找
        if ("update".equals(type)) {
            //添加业务
        }
        map.put("student", teamById);
        return "teacher/team/" + type;
    }


    //修改队伍信息
    @PutMapping("/teams")
    public String update(TeamList teamList) {

        teamService.updateTeam(teamList);
        return "redirect:/teams";
    }

    //跳转到添加页面
    @GetMapping("/addTeam")
    public String toAddPage(Map<String, Object> map) {

        Teacher teacher = new Teacher();
        List<Teacher> list = teacherService.list(teacher);
        //所有指导老师
        map.put("teachers", list);

        Student student = new Student();
        List<Student> list1 = studentService.list(student);
        //所有学生
        map.put("students", list1);

        Race race = new Race();
        List<Race> list2 = raceService.list(race);
        map.put("races", list2);

        return "teacher/team/add";
    }

    //添加数据
    @PostMapping("/teams")
    public String add(Team team) {

        logger.info("添加teamList的数据" + team);
        team.setUpdateId(team.getTeacherId());
        //保存数据操作
        teamService.addTeam(team);
        return "redirect:/teams";
    }

    /*
     * 通过json验证队伍名字是否重复
     * */
    @ResponseBody
    @GetMapping("/teams/team/{teamName}")
    public Boolean judgeTeam(@PathVariable("teamName") String teamName) {
        List<TeamList> list = teamService.list(new TeamList());
        //判断当前队伍是否存在，存在返回true
        for (TeamList team : list) {
            if (team.getTeamName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }


    //删除数据
    @DeleteMapping("/teams/{temid}")
    public String deleteBill(@PathVariable("temid") Integer temid) {
        teamService.deleteTeam(temid);
        return "redirect:/teams";
    }

}
