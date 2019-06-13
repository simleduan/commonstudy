package com.sime.annotion.service;

import org.springframework.stereotype.Service;

@Service
public class TypeService {

    public String getIvokeType(){
        return "我是使用类型调用的";
    }
}
