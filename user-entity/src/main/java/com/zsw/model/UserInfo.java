package com.zsw.model;

import java.util.Date;

/**
 * @author zsw
 * @date 2021/4/9 11:03
 * @description :  用户登录的用户信息
 */
@lombok.Data
public class  UserInfo {

    private int id;
    private  String userName; //用户名
    private  String password;    //密码
    private  String phone;    //手机号码
    private  int status;    //账户状态
    private Date lockEndTime;    //锁定结束时间
    private int failNumber;    //登录失败次数
}
