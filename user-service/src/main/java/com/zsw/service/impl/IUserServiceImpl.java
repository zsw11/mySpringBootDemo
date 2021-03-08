package com.zsw.service.impl;

import com.zsw.dao.UserMapper;
import com.zsw.enumModel.Status;
import com.zsw.model.User;
import com.zsw.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zsw
 * @date 2021/3/8 13:45
 * @description :
 */
@Service
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Status addUser(User user) {
        int i = userMapper.addUser(user.getAddress(),user.getAge(),user.getEmail(),user.getName(),user.getPhone(),user.getBlog());
        if (i > 0) {
            return Status.SUCCESS;
        }
        return Status.FAIL;
    }
}
