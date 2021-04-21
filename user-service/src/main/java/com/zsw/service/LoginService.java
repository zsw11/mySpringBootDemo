package com.zsw.service;

import com.zsw.ResultResp;

import java.util.HashMap;

/**
 * @author zsw
 * @date 2021/4/9 11:11
 * @description :
 * 策略模式的定义: 定义一系列的算法(LoginService的实现类),把它们一个个封装起来, 并且使它们可相互替换。
 *
 * 其实不管哪种方式登录，他们都属于一种登录行为，只是他们在不同的登录方式上验证的信息指标不同而已，
 * 那么意味着我们可以把登录行为定义成一个接口，具体如何登录就根据不同的登录行为交给对应的登录实现类，统一对外暴露的对象类型都是这个接口类型。
 */

public interface LoginService {
    //缓存登录方式和处理策略对象的关系，通过不同的登录类型得到不同的登录方式
    HashMap loginServerMap=new HashMap<Integer,LoginService>();

    /**
     * 登录
     * @param username
     * @param content
     * @return
     */
    ResultResp login(String username, String content);
}
