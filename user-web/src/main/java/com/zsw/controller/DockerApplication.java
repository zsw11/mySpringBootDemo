package com.zsw.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @date 2021/3/1 10:26
 * @description :
 */
@RestController
public class DockerApplication {
    @RequestMapping("/src/main/docker")
    public String dockerTest() {
        return "hello docker";
    }
}
