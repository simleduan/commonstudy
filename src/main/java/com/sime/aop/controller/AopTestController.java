package com.sime.aop.controller;

import com.sime.aop.services.AopTestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopTestController {

    @Autowired
    private AopTestServices aopTestServices;

    @RequestMapping("aop/common")
    public String helloAop(){
        String result = "hello i'm comming";
//        long start = System.currentTimeMillis();
        String str = aopTestServices.aopTest();
//        long end = System.currentTimeMillis();
//        System.out.println("使用时间为："+String.valueOf(end-start));
        return str;
    }
}
