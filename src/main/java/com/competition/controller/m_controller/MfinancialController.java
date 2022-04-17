package com.competition.controller.m_controller;

import com.competition.entities.*;
import com.competition.service.FinancialService;
import com.competition.service.PredictFinancialService;
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

import java.util.List;
import java.util.Map;

//经费管理
@Controller
public class MfinancialController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    FinancialService financialService;
    @Autowired
    PredictFinancialService predictFinancialService;
    @Autowired
    RaceService raceService;
    @Autowired
    TeamService teamService;

    //经费管理
    @GetMapping("/mfinancials")
    public String list(Map<String, Object> map, PredictFinancialList predictFinancialList, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 8);
        List<PredictFinancialList> list = predictFinancialService.list(predictFinancialList);
        PageInfo<PredictFinancialList> pageInfo = new PageInfo<PredictFinancialList>(list);
        for (PredictFinancialList f : list) {
            f.setTotalPrice(f.getRoomPrice() + f.getCarPrice() + f.getPaymentPrice());
        }
        map.put("pageInfo", pageInfo);
        System.out.println("-_- -->" + pageInfo);
        map.put("teamName", predictFinancialList.getTeamName());
        return "manager/financial/list";
    }

    /*
     * 进入查看详情页面
     * */
    @GetMapping("/mfinancials/{fid}")
    public String view(@PathVariable("fid") Integer fid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {
        logger.info("查询" + fid + "的详细信息");
        PredictFinancialList predictFinancialList = predictFinancialService.getPredictFinancialById(fid);

        float total = predictFinancialList.getPaymentPrice() + predictFinancialList.getCarPrice() + predictFinancialList.getRoomPrice();
        predictFinancialList.setTotalPrice(total);

        map.put("financial", predictFinancialList);
        return "manager/financial/" + type;
    }


    //跳转到添加页面
    @GetMapping("/addPredictFinance")
    public String toAddPage(Model map) {
        List<TeamList> list = teamService.list(new TeamList());
        List<Race> list2 = raceService.list(new Race());
        map.addAttribute("races", list2);
        map.addAttribute("teams", list);

        return "manager/financial/add";
    }

    //添加数据
    @PostMapping("/addPredictFinancial")
    public String add(PredictFinancial predictFinancial) {

        predictFinancial.setTotalPrice(predictFinancial.getCarPrice() + predictFinancial.getPaymentPrice() + predictFinancial.getRoomPrice());
        predictFinancialService.addPredictFinancialList(predictFinancial);
        return "redirect:/mfinancials";
    }

    //删除数据
    @DeleteMapping("/mfinancials/{fid}")
    public String deleteBill(@PathVariable("fid") Integer fid) {
        predictFinancialService.deletePredictFinancialList(fid);
        return "redirect:/mfinancials";
    }
}
