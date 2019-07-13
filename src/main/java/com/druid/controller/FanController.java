package com.druid.controller;

import com.druid.entity.IctLoanProperty;
import com.druid.service.IctLoanPropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j(topic = "interfaceLogger")
public class FanController {

    @Resource
    private IctLoanPropertyService ictLoanPropertyService;

    @RequestMapping("fanbin")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("selectinfo/{id}")
    public IctLoanProperty selectByPrimaryKey(@PathVariable Integer id){
        log.info("request parameter is [{}]"+id);
        IctLoanProperty IctLoanProperty = ictLoanPropertyService.selectByPrimaryKey(id);
        return IctLoanProperty;

    }
}
