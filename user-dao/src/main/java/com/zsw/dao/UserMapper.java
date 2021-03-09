package com.zsw.dao;

import com.zsw.model.User;

import java.util.List;

/**
 * @author zsw
 * @date 2021/3/8 13:50
 * @description :
 */
public interface UserMapper {

    int addUser(User user);

    int updateUser(User user);

    int delete(int id);

    List<User> get();
}
