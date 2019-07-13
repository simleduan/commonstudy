package com.druid.service;

import com.druid.dao.IctLoanPropertyMapper;
import com.druid.entity.IctLoanProperty;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IctLoanPropertyService {

    @Resource
    IctLoanPropertyMapper ictLoanPropertyMapper;

    public IctLoanProperty selectByPrimaryKey(Integer id){
        IctLoanProperty ictLoanProperty = ictLoanPropertyMapper.selectByPrimaryKey(id);
        return ictLoanProperty;
    }

}
