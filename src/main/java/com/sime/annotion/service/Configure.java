package com.sime.annotion.service;

import com.sime.annotion.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configure {

    @Bean("fanbin")
    public Person getFanbin(){
        Person person = new Person();
        person.setAge("12");
        person.setName("樊斌");
        return person;
    }

    @Bean("meinv")
    public Person getmeinv(){
        Person person = new Person();
        person.setAge("18");
        person.setName("王主席");
        return person;
    }
}
