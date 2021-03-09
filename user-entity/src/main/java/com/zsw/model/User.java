package com.zsw.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author zsw
 * @date 2021/1/13 10:41
 * @description :
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@ApiModel
@Component
public class User {
    @Id
    private int id;

    @ApiParam("用户姓名")
    @Size(min = 3, max = 10)
    private String name;

    // 读取 ValidationMessage.properties 的信息
//    @NotNull(message = "{user.address.notnull}")  读取 ValidationMessage.properties 的信息
    @NotNull //使用默认提示信息
    @ApiParam("用户地址")
    private String address;

    @DecimalMin(value = "1",message = "{user.age.size}")
    @DecimalMax(value = "200",message = "{user.age.size}")
    @ApiParam("用户年龄")
    private Integer age;

    @ApiParam("用户电话")
    private String phone;

    @ApiParam("用户博客")
    private String blog;

    @Email(message = "{user.email.pattern}")
    @NotNull(message = "{user.email.notnull}")
    @ApiParam("用户邮箱")
    private String email;
}
