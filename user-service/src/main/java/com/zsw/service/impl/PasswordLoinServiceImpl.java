package com.zsw.service.impl;

import com.zsw.ResultResp;
import com.zsw.dao.UserLoginDao;
import com.zsw.model.UserInfo;
import com.zsw.service.LoginHelper;
import com.zsw.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zsw
 * @date 2021/4/9 11:12
 * @description : 通过密码登录
 */
@Service
public class PasswordLoinServiceImpl implements LoginService {

    @Autowired
    private UserLoginDao userLoginDao;

    public PasswordLoinServiceImpl() {
        // this 指当前对象的引用    class 指 该类
        System.out.println(this); //com.zsw.service.impl.PasswordLoinServiceImpl@83e635f
        System.out.println(PasswordLoinServiceImpl.this); //com.zsw.service.impl.PasswordLoinServiceImpl@83e635f
        System.out.println(PasswordLoinServiceImpl.class); //class com.zsw.service.impl.PasswordLoinServiceImpl
        LoginService.loginServerMap.put(1, this);
    }

    @Override
    public ResultResp login(String username, String content) {
        //查询用户信息
        UserInfo userInfo = userLoginDao.queryByUserName(username);
        //检查用户状态
        ResultResp result= LoginHelper.checkUserStatus(userInfo);
        if (result != null) {
            return result;
        }
        // 根据登录类型验证对应的数据。
        if (!content.equals(userInfo.getPassword())) {
            UserInfo userInfo1 = LoginHelper.loginFail(userInfo);
            userLoginDao.updateUserInfo(userInfo1);
            return ResultResp.fail("密码错误");
        }
        return  LoginHelper.success(userInfo);
    }


}
