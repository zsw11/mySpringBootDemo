package com.zsw.service;

import com.zsw.dao.userDao;
import com.zsw.entity.user;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @date 2021/1/13 10:49
 * @description :
 */
@Service
public class userService {
  @Resource
  private com.zsw.dao.userDao userDao;

  public List<user> userList(){
    return userDao.userList();
  }

}
