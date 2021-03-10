package com.zsw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zsw
 * @date 2021/3/1 10:26
 * @description :
 */
@RestController
public class DockerApplication {
    @GetMapping("/docker")
    public String dockerTest() {
        return "hello docker";
    }

    @GetMapping("/nginx")
    public String hello() {
        System.out.println("测试nginx负载均衡");
        return "hello nginx";
    }

    @GetMapping("/")
    public String hellozsw() {
        return "hello zsw";
    }
}
