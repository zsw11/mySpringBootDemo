package com.zsw.service;

import com.zsw.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

/**
 * @author zsw
 * @date 2021/1/29 14:12
 * @description :
 */
@Service
@Slf4j
public class GitHubLookupService {

    private RestTemplate restTemplate;

    //RestTemplate去请求，另外加上类@Async 表明是一个异步任务
    public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Future<User> findUser(String user) throws InterruptedException {
        log.info("findUser:{}",user);
        String url = String.format("https://api.github.com/users/%s", user); // httpfang方式的请求地址
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(10L);
        return new AsyncResult<>(results);
    }
}
