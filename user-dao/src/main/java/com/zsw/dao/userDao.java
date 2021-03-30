package com.zsw.dao;

import com.zsw.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zsw
 * @date 2021/1/13 10:51
 * @description :
 */
@Component
public class userDao {

    public List<User> userList(){
        ArrayList<User> userArrayList = new ArrayList<User>();
        for (int i = 1; i <= 10; i++) {
            User user = new User();
            user.setId(i);
            user.setAddress("广州地址："+i);
            user.setAge(19+i);
            user.setName("zsw:"+i);
            user.setPhone("15172521070");
            userArrayList.add(user);
        }
        return userArrayList;
    }
}
