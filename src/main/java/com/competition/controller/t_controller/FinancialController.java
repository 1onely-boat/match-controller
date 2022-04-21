package com.competition.controller.t_controller;

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

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class FinancialController {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    FinancialService financialService;
    @Autowired
    RaceService raceService;
    @Autowired
    TeamService teamService;
    @Autowired
    PredictFinancialService predictFinancialService;



    //经费管理
    @GetMapping("/financials")
    public String list(HttpSession session, Map<String, Object> map, FinancialList financialList, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        Teacher loginUser = (Teacher)session.getAttribute("loginUser");
        //分页为12条一页

        PageHelper.startPage(pageNum, 12);
        List<FinancialList> list = financialService.myList(financialList, loginUser.getTid());
        PageInfo<FinancialList> pageInfo = new PageInfo<FinancialList>(list);
        for (FinancialList f : list) {
            f.setTotalFee(f.getRoomFee() + f.getCarFee() + f.getPaymentFee());
        }
        map.put("pageInfo", pageInfo);
        map.put("teamName", financialList.getTeamName());

        return "teacher/financial/list";
    }

    /*
     * 跳转到添加经费addFinancial
     **/
    @GetMapping("/toAddFinancial")
    public String toadd(Model map, HttpSession session) {
        Teacher loginUser = (Teacher)session.getAttribute("loginUser");
        List<TeamList> list = teamService.myList(new TeamList(), loginUser.getTid());
        List<Race> list2 = raceService.list(new Race());
        List<PredictFinancialList> list1 = predictFinancialService.list(new PredictFinancialList());
        map.addAttribute("races", list2);
        map.addAttribute("teams", list);
        map.addAttribute("predictLists", list1);
        return "teacher/financial/add";
    }

    //添加数据
    @PostMapping("/addFinancial")
    public String add(Financial financial) {
        financial.setTotalFee(financial.getCarFee() + financial.getRoomFee() + financial.getPaymentFee());
        financialService.addFinancial(financial);
        return "redirect:/financials";
    }


    /*
     * 进入查看详情页面
     * */
    @GetMapping("/financials/{fid}")
    public String view(@PathVariable("fid") Integer fid, Map<String, Object> map,
                       @RequestParam(value = "type", defaultValue = "view") String type) {
        logger.info("查询" + fid + "的详细信息");
        FinancialList financialById = financialService.getFinancialById(fid);

        float total = financialById.getPaymentFee() + financialById.getCarFee() + financialById.getRoomFee();
        financialById.setTotalFee(total);

        map.put("financial", financialById);
        float a = financialById.getTotalFee() - financialById.getTotalPrice();
        map.put("num", Math.abs(a));
        return "teacher/financial/" + type;
    }

    //删除数据
    @DeleteMapping("/financials/{fid}")
    public String deleteBill(@PathVariable("fid") Integer fid) {
        financialService.deleteFinancial(fid);
        return "redirect:/financials";
    }
}
