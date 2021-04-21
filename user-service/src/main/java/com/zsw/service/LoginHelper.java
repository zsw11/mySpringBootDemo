package com.zsw.service;

import com.zsw.ResultResp;
import com.zsw.model.UserInfo;

import java.util.Date;

/**
 * @author zsw
 * @date 2021/4/9 13:45
 * @description : 登录校验等的公共方法
 */
public class LoginHelper {

    /**
     * 校验用户状态
     * @param userInfo
     * @return
     */
    public static ResultResp checkUserStatus(UserInfo userInfo) {
        if (userInfo == null) {
            return new ResultResp(001, "用户不存在", null);
        }
        //检查用户是否被禁用 0正常，1 禁用
        if (userInfo.getStatus() == 1) {
            return new ResultResp(002, "账户被禁用", userInfo);
        }
        //检查用是否被锁
        Date lockEndTime = userInfo.getLockEndTime();
        if (lockEndTime != null && lockEndTime.getTime() >= System.currentTimeMillis()) {
            return new ResultResp(003, "账户已被锁定", userInfo);
        }
        return null;
    }

    public static UserInfo loginFail(UserInfo userInfo) {
        userInfo.setFailNumber(userInfo.getFailNumber()+1);
        if (userInfo.getFailNumber() > 5) {
            userInfo.setLockEndTime(new Date(userInfo.getLockEndTime().getTime()+1800*1000));
        }
        return userInfo;
    }

    public static ResultResp success(UserInfo userInfo) {
        return ResultResp.success("登录成功token:66666666");
    }
}
