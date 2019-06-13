package com.sime.annotion.controller;

import com.sime.annotion.pojo.Person;
import com.sime.annotion.service.NameService;
import com.sime.annotion.service.QualifierService;
import com.sime.annotion.service.TypeService;
import com.sime.configinfo.ConfigInfoProper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NameTypeInvokeController {

    @Autowired
    private TypeService typeService;

    @Resource
    @Qualifier("nameInvokeMe")
    private NameService nameService;

    @Resource
    @Qualifier("fanbin")
    private Person fanbin;

    @Resource
    @Qualifier("meinv")
    private Person meinv;

    @Autowired
    @Qualifier("danduQualifier")
    private QualifierService qualifierService;

    @Autowired
    private ConfigInfoProper configInfoProper;

    @RequestMapping( method = RequestMethod.GET,value = "/invokeType")
    public String invokeNameType(){
        return typeService.getIvokeType();
    }


    @RequestMapping( method = RequestMethod.GET,value = "/invokeName")
    public String invokeNameName(){
        return nameService.getIvokeType();
    }

    @RequestMapping( method = RequestMethod.GET,value = "/invokeFanbin")
    public String invokeFanbin(){
        return fanbin.getName();
    }

    @RequestMapping( method = RequestMethod.GET,value = "/invokemeinv")
    public String invokemeinv(){
        return meinv.getName();
    }

    @RequestMapping( method = RequestMethod.GET,value = "/invokedandu")
    public String invokedandu(){
        return qualifierService.getIvokeQualifier();
    }

    @GetMapping(value = "/getMapping")
    public String getMappingTest(){
        return "getmapping i'm comming";
    }

    @GetMapping(value = "/getConfigInfo")
    public String getConfigInfo(){
        String language = configInfoProper.getLanguage();
        String eat = configInfoProper.getEat();
        String girl = configInfoProper.getGirl();
        return language+"---"+eat+"---"+girl;
    }
}
