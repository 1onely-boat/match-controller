package com.competition.mapper;

import com.competition.entities.PredictFinancial;
import com.competition.entities.PredictFinancialList;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PredictFinancialMapper {

    //获得列表
    List<PredictFinancialList> getLists(PredictFinancialList predictFinancialList);
    //通过id查找
    PredictFinancialList getPredictFinancialById(Integer preid);
    //添加
    int addPredictFinancial(PredictFinancial predictFinancial);
    //修改
   // int updateFinancial(PredictFinancial financial);
    //通过ID删除
    int deletePredictFinancialById(Integer preid);
}
