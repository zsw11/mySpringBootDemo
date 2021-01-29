package com.zsw.componentConfig;

import com.zsw.entity.User;
import com.zsw.service.GitHubLookupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author zsw
 * @date 2021/1/29 14:20
 * @description :  测试异步Async
 */
//@Component  注释掉
@Slf4j
@Async
public class AppRunner implements CommandLineRunner {
    @Resource
    private GitHubLookupService gitHubLookupService;


    //项目启动会执行run()，会另起一个线程和主线程main一起异步执行
    @Override
    public void run(String... strings) throws Exception {
        long start = System.currentTimeMillis();
        // Kick of multiple, asynchronous lookups
        Future<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        Future<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        Future<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        while (!(page1.isDone() && page2.isDone() && page3.isDone())) {
            Thread.sleep(10); //10-millisecond pause between each check
        }

         // Print results, including elapsed time
        log.info("Elapsed time: " + (System.currentTimeMillis() - start));
        log.info("--> " + page1.get());
        log.info("--> " + page2.get());
        log.info("--> " + page3.get());
    }
}
