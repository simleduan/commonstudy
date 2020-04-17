package com.generator.entity;

public class Person {
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 家乡
     */
    private String hometown;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @return name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 性别
     * @return gender 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别
     * @return gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 家乡
     * @return hometown 家乡
     */
    public String getHometown() {
        return hometown;
    }

    /**
     * 家乡
     * @return hometown 家乡
     */
    public void setHometown(String hometown) {
        this.hometown = hometown == null ? null : hometown.trim();
    }
}