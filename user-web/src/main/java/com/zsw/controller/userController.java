package com.zsw.controller;

import com.zsw.entity.user;
import com.zsw.service.userService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @date 2021/1/13 10:39
 * @description :
 */
@RestController
@RequestMapping("/v1/user")
public class userController {

    @Resource
    private com.zsw.service.userService userService;

    @GetMapping("/list")
    public List<user> listUser() {
        return userService.userList();
    }
}
