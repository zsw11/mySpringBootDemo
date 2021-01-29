package com.zsw.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zsw
 * @date 2021/1/13 10:41
 * @description :
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class User {
    private int id;
    private String name;
    private String address;
    private Integer age;
    private String phone;
    private String blog;
}
