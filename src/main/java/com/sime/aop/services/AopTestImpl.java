package com.sime.aop.services;

import org.springframework.stereotype.Service;

@Service("aopTest")
//@Service
//public class AopTestImpl implements AopTest {
public class AopTestImpl{
//    @Override
    public String getAopInfo() {
        System.out.println("AopTestImpl is running");
        return null;
    }
}
