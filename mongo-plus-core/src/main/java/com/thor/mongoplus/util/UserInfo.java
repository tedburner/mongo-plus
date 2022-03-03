package com.thor.mongoplus.util;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author: lingjun.jlj
 * @date: 2022/3/3 23:25
 * @description:
 */
public class UserInfo {
    private String name;
    @Field(value = "user_age")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
