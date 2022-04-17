package com.competition.service.impl;

import com.competition.entities.Financial;
import com.competition.entities.FinancialList;
import com.competition.entities.PredictFinancial;
import com.competition.entities.PredictFinancialList;
import com.competition.mapper.FinancialMapper;
import com.competition.mapper.PredictFinancialMapper;
import com.competition.service.FinancialService;
import com.competition.service.PredictFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PredictFinancialServiceImpl implements PredictFinancialService {

    @Autowired
    PredictFinancialMapper predictFinancialMapper;

    @Override
    public List<PredictFinancialList> list(PredictFinancialList predictFinancialList) {
        return predictFinancialMapper.getLists(predictFinancialList);
    }

    @Override
    public PredictFinancialList getPredictFinancialById(Integer fid) {
        return predictFinancialMapper.getPredictFinancialById(fid);
    }

    @Override
    public int addPredictFinancialList(PredictFinancial predictFinancial) {
        return predictFinancialMapper.addPredictFinancial(predictFinancial);
    }

    @Override
    public int deletePredictFinancialList(Integer fid) {
        return predictFinancialMapper.deletePredictFinancialById(fid);
    }
}
