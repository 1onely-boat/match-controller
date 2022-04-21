package com.competition.controller.m_controller;

import com.competition.entities.*;
import com.competition.service.AwardService;
import com.competition.service.RaceService;
import com.competition.service.TeacherService;
import com.competition.service.TeamService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Des MawardController
 * @Author guyu
 * @Date 2020/7/11 22:34
 * @Param
 * @Return
 */

//比赛结果
@Controller
public class MawardController {


    @Autowired
    AwardService awardService;

    Logger logger = LoggerFactory.getLogger(getClass());

    //获得列表
    @GetMapping("/mawards")
    public String list(Map<String, Object> map, AwardList awardList, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //分页为8条一页
        PageHelper.startPage(pageNum, 8);
        //  System.out.println("awardList ->"+awardList);
        List<AwardList> races = awardService.getLists(awardList);
        PageInfo<AwardList> pageInfo = new PageInfo<AwardList>(races);
        map.put("pageInfo", pageInfo);
        //回显队伍名，教师名
        map.put("raceName", awardList.getRaceName());
        map.put("teacherName", awardList.getTeacherName());
        //  System.out.println("pageInfo"+pageInfo);
        //跳转到award列表
        return "manager/award/list";
    }

    /*
     * 进入查看详情页面
     * */
    @GetMapping("/mawards/{teid}")
    public String view(@PathVariable("teid") Integer teid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {
        logger.info("查询" + teid + "的详细信息");
        AwardList award = awardService.getAwardListById(teid);
        map.put("award", award);
        Integer status = award.getIfApprove();
        //审核通过
        if (status == 1) {
            return "manager/award/view";
        }
        //审核未通过
        else {
            return "manager/award/viewsearch";
        }

    }

    /*
     * 审核
     **/

    @GetMapping("/maccessAward/{aid}")

    public String accessAward(@PathVariable("aid") Integer aid) {
        AwardList awardListById = awardService.getAwardListById(aid);
        awardListById.setIfApprove(1);
        awardService.updateAwardList(awardListById);
        return "redirect:/mawards";
    }


    /*
     * 删除获奖
     * */
    @DeleteMapping("/mawards/{teid}")
    public String del(@PathVariable("teid") Integer teid) {
        awardService.deleteAwardListById(teid);
        return "redirect:/mawards";
    }


    @Autowired
    TeacherService teacherService;
    @Autowired
    RaceService raceService;
    @Autowired
    TeamService teamService;
    /*
     * 跳转到添加页面
     * */
    @GetMapping("/addAward")
    public String toAddPage(Map<String, Object> map) {
        //查询导师

        List<Teacher> teachers = teacherService.list(new Teacher());
        map.put("teachers", teachers);
        //查询比赛
        List<Race> races = raceService.list(new Race());
        map.put("races", races);
        //查询队伍
        List<TeamList> teamLists = teamService.list(new TeamList());
        map.put("teamLists", teamLists);

        return "teacher/award/add";
    }

    //添加数据
    @PostMapping("/addAward")
    public String add(MultipartFile[] fileUpload, MultipartFile[] fileUpload2, Award award) {
        logger.info("添加award的数据" + award);
        //-------------
        for (MultipartFile file : fileUpload) {
            //获取文件名以及后缀名
            String fileName = file.getOriginalFilename();
            //重新生成文件名(根据自己的业务进行命名)
            fileName = "certificate_" + fileName;
            //指定上传文件本地存储目录
            String dirPath = "/Users/apple/Downloads/spaces_idea/src/main/resources/static/img/goods/";
            File filepath = new File(dirPath);

            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
                award.setCertificatePicture(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("上传图片失败" + e.getMessage());
            }
        }
        for (MultipartFile file : fileUpload2) {
            //获取文件名以及后缀名
            String fileName = file.getOriginalFilename();
            //重新生成文件名(根据自己的业务进行命名)
            fileName = "activity_" + fileName;
            //指定上传文件本地存储目录
            String dirPath = "/Users/apple/Downloads/spaces_idea/src/main/resources/static/img/goods/";
            File filepath = new File(dirPath);

            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            try {
                file.transferTo(new File(dirPath + fileName));
                award.setActivityPicture(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("上传图片失败" + e.getMessage());
            }
        }

        //-------------
        //保存数据操作
        awardService.addAwardList(award);

        return "redirect:/mawards";
    }
}
