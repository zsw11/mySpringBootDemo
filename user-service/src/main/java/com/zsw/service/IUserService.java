package com.zsw.service;

import com.zsw.model.User;

import java.util.List;

/**
 * @author zsw
 * @date 2021/3/8 13:44
 * @description :
 */
//@Service
public interface IUserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 获取用户
     * @return
     */
    List<User> get();

 }
