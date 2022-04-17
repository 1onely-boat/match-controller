package com.competition.mapper;

import com.competition.entities.Financial;
import com.competition.entities.FinancialList;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialMapper {

    //获得列表
    List<FinancialList> getLists(FinancialList financialList);
    //通过id查找
    FinancialList getFinancialById(Integer fid);
    //添加
    int addFinancial(Financial financial);
    //修改
   // int updateFinancial(Financial financial);
    //通过ID删除
    int deleteFinancialById(Integer fid);
}
