package com.redis.test;

import com.redis.pojo.User;
import com.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/redis")
public class Test {

    private String testString = "testString";
    private String userKey = "userKey";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/add")
    public String add() {
        //1,添加一个Value为String
        stringRedisTemplate.opsForValue().set(testString, "测试存储字符串类型");
        //2,添加一个Value为对象
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("1111");
        user.setRediskey(userKey);
        redisTemplate.opsForValue().set(user.getRediskey(), user);
        return "成功";
    }

    @RequestMapping("/getUser")
    public User findUserByKey() {
        User user = (User) redisTemplate.opsForValue().get(userKey);
        return user;
    }

    @RequestMapping("/getString")
    public String findString() {
        String s = stringRedisTemplate.opsForValue().get(testString);
        return s;
    }
    @RequestMapping("/delete")
    public String deleteByKey(){
        //1,删除string类型
        stringRedisTemplate.delete(testString);
        //2,删除user对象
        redisTemplate.delete(userKey);
        return "删除成功";
    }
}
