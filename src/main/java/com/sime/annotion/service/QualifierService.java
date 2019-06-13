package com.sime.annotion.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("danduQualifier")
public class QualifierService {

    public String getIvokeQualifier(){
        return "我是danduQualifier";
    }
}
