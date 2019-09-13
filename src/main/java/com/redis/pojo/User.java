package com.redis.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;
    private String rediskey;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRediskey() {
        return rediskey;
    }

    public void setRediskey(String rediskey) {
        this.rediskey = rediskey;
    }

    public User(){

    }

    public User(int id, String username, String password, String rediskey) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rediskey = rediskey;
    }
}
