package com.zsw.controller;

import com.zsw.entity.User;
import com.zsw.entity.UserConfig;
import com.zsw.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @date 2021/1/13 10:39
 * @description :
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserConfig userConfig;

    @GetMapping("/list")
    public List<User> listUser() {
        return userService.userList();
    }

    @PostMapping("/user")
    public UserConfig user(){

        return userConfig;
    }


}
