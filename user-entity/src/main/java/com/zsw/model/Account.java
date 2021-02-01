package com.zsw.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zsw
 * @date 2021/1/29 16:00
 * @description :
 */
@Data
@ApiModel
public class Account implements Serializable {

    @ApiParam(name = "id")
    private int id;
    @ApiParam(name = "name")
    private String name;
    @ApiParam(name = "money")
    private double money;
}
