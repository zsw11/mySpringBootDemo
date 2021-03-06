package com.zsw.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zsw
 * @date 2021/1/28 9:39
 * @description :
 */
@ConfigurationProperties(prefix="user")
@Component
public class UserConfig {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
