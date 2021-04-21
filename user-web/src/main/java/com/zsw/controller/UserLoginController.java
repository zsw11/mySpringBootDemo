package com.zsw.controller;

import com.zsw.ResultResp;
import com.zsw.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @date 2021/4/9 11:01
 * @description :策略模式与模板模式 在登录方面的应用
 */
@Api
@RestController("/userLogin")
public class UserLoginController {

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultResp login(String username, String content, Integer loginType) {
        //根据登录类型，获取对应的登录策略处理对象
        LoginService loginService  = (LoginService) LoginService.loginServerMap.get(loginType);
        return loginService.login(username, content);
    }

}
