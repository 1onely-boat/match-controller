package com.competition.service.impl;

import com.competition.entities.Financial;
import com.competition.entities.FinancialList;
import com.competition.mapper.FinancialMapper;
import com.competition.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    FinancialMapper financialMapper;
    @Override
    public List<FinancialList> list(FinancialList financialList) {
        return financialMapper.getLists(financialList);
    }

    @Override
    public FinancialList getFinancialById(Integer fid) {
        return financialMapper.getFinancialById(fid);
    }

    @Override
    public int addFinancial(Financial financial) {
        return financialMapper.addFinancial(financial);
    }

/*
    @Override
    public int updateFinancial(Financial financial) {
        return financialMapper.updateFinancial(financial);
    }
*/
    @Override
    public int deleteFinancial(Integer fid) {
        return financialMapper.deleteFinancialById(fid);
    }
}
