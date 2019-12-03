package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class KafkaController {

    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/message/{message}")
    public boolean send(@PathVariable String message){
        System.out.println("message : "+message);
        kafkaTemplate.send("testTopic",message);
        return true;
    }

}
