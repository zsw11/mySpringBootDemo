package com.zsw.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zsw
 * @date 2021/1/29 16:00
 * @description :
 */
@Data
public class Account implements Serializable {
    private int id ;
    private String name ;
    private double money;
}
