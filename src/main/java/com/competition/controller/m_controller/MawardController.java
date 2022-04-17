package com.competition.controller.m_controller;

import com.competition.entities.*;
import com.competition.service.AwardService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
