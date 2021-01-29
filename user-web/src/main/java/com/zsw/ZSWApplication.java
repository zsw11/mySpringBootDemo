package com.zsw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zsw
 * @date 2021/1/13 10:36
 * @description :
 */
@SpringBootApplication
@EnableAsync //开启异步
public class ZSWApplication extends AsyncConfigurerSupport {
    public static void main(String[] args) {
        SpringApplication.run(ZSWApplication.class);

    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor  = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2); // 核心线程数
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GithubLookup-"); //线程名称
        executor.initialize();
        return executor;

    }
}
