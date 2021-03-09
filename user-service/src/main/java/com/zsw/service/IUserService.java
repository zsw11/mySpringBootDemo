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

    int addUser(User user);

    int update(User user);

    int delete(int id);

    List<User> get();

 }
