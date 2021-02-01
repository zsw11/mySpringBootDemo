package com.zsw.service;

import com.zsw.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @date 2021/1/13 10:49
 * @description :
 */
@Service
public class UserService {
  @Resource
  private com.zsw.dao.userDao userDao;

  public List<User> userList(){
    return userDao.userList();
  }

}
