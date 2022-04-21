package com.competition.service;

import com.competition.entities.Financial;
import com.competition.entities.FinancialList;
import com.competition.entities.Student;

import java.util.List;

public interface FinancialService {


    List<FinancialList> myList(FinancialList financialList, Integer tid);

    //List<Financial> list(Financial financial);
    List<FinancialList> list(FinancialList financialList);

    FinancialList getFinancialById(Integer fid);

    int addFinancial(Financial financial);

   /* int updateFinancial(Financial financial);*/

    int deleteFinancial(Integer fid);

}
