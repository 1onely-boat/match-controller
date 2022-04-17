package com.competition.service;

import com.competition.entities.PredictFinancial;
import com.competition.entities.PredictFinancialList;

import java.util.List;

public interface PredictFinancialService {

    //List<Financial> list(Financial financial);
    List<PredictFinancialList> list(PredictFinancialList predictFinancialList);

    PredictFinancialList getPredictFinancialById(Integer fid);

    int addPredictFinancialList(PredictFinancial predictFinancial);

   /* int updateFinancial(Financial financial);*/

    int deletePredictFinancialList(Integer fid);

}
