package com.zsw.service.impl;

import com.zsw.dao.UserMapper;
import com.zsw.model.User;
import com.zsw.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @date 2021/3/8 13:45
 * @description :
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
//        User user1 = new User();
//        BeanUtils.copyProperties(user,user1);
        int i = userMapper.addUser(user); //这里可以直接传对象
//        int i = userMapper.addUser(user1.getAddress(),user1.getAge(),user1.getEmail(),user1.getName(),user1.getPhone(),user1.getBlog());
//        if (i > 0) {
//            return Status.SUCCESS;
//        }
        return user.getId(); //返回插入的id
    }

    @Override
    public int update(User user) {
        userMapper.updateUser(user);
        return user.getId();

    }

    @Override
    public int delete(int id) {
        int delete = userMapper.delete(id);
        return delete;
    }

    @Override
    public List<User> get() {
       return userMapper.get();
    }
}
