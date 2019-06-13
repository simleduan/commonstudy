package com.sime.configinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


@Configuration
public class EnvConfig {

    @Autowired
    private Environment environment;

    @Bean
    public void getEnvironmentInfo(){
        String name = environment.getProperty("ENVIRONMENT_INFO_NAME");
        String age = environment.getProperty("ENVIRONMENT_INFO_AGE");
        System.out.println("Environment方式获取属性文件内容"+name);
        System.out.println("Environment方式获取属性文件内容"+age);
    }

    @Value("${fanbin.name}")
    private String name;
    @Value("${fanbin.age}")
    private String age;
    @Value("${fanbin.city}")
    private String city;

    @Bean
    public void getAnnotionInfo(){
        System.out.println("Annotion方式获取属性文件内容"+name);
        System.out.println("Annotion方式获取属性文件内容"+age);
        System.out.println("Annotion方式获取属性文件内容"+city);
    }

    @Value("${fanbinwife.girlfriend.name}")
    private String gname;
    @Value("${fanbinwife.girlfriend.age}")
    private String gage;


    @Bean
    public void getAnnotionThreeInfo(){
        System.out.println("Annotion方式获取属性文件内容"+gname);
        System.out.println("Annotion方式获取属性文件内容"+gage);
    }


}
