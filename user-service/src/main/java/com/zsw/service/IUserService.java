package com.zsw.service;

import com.zsw.enumModel.Status;
import com.zsw.model.User;

/**
 * @author zsw
 * @date 2021/3/8 13:44
 * @description :
 */
//@Service
public interface IUserService {

    Status addUser(User user);
 }
