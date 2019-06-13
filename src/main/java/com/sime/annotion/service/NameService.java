package com.sime.annotion.service;

import org.springframework.stereotype.Service;

@Service("nameInvokeMe")
public class NameService {

    public String getIvokeType(){
        return "我是使用名称调用的";
    }
}
