package com.sime.invoke;

import lombok.Data;


public class InvokeMeTest {

    private String namePrivate;
    public String namePublic;
    private String methodPrivate(){
        return "我是私有的方法";
    }
    public String methodPublic(){
        return "我是共有的方法";
    }
}
