package com.zsw.controller;

import com.zsw.model.Account;
import com.zsw.model.MailConstants;
import com.zsw.model.MailSendLog;
import com.zsw.service.impl.AccountServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author zsw
 * @date 2021/1/29 16:07
 * @description :
 */
@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {
    @Autowired
    AccountServiceImpl accountService;
    @Resource
    RabbitTemplate rabbitTemplate;
    @Resource
    RedisTemplate redisTemplate;

    @ApiOperation(value = "获取Account", notes="获取图书")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        MailSendLog mailSendLog = new MailSendLog();
        mailSendLog.setEmpId(1);
        mailSendLog.setCount(1);
        mailSendLog.setCreateTime(new Date());
        mailSendLog.setMsgId("id111");
        mailSendLog.setStatus(MailConstants.SUCCESS);
        mailSendLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
        mailSendLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
        rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME, mailSendLog, new CorrelationData(mailSendLog.getMsgId()));
        return accountService.findAccountList();
    }

    @ApiOperation(value = "通过id获取Account", notes="通过id获取账户")
    @ApiImplicitParam(name = "id",value = "账户id",required = true,dataType = "int")
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.findAccount(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        int t= accountService.update(name,money,id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @ApiOperation(value = "删除Account", notes="删除account")
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id")int id) {
        int t= accountService.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }

    }

    @ApiOperation(value = "新增Account", notes="新增account")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") @NotNull(message = "名称不能为空") String name,
                              @RequestParam(value = "money") double money) {

        int t= accountService.add(name,money);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }
    }
    @ApiOperation(value = "清理redis缓存", notes="清理redis缓存")
    @RequestMapping(value = "/clearRedis", method = RequestMethod.GET)
    public void clearRedis(){
        // 清除所有的reids缓存
        Set keys = redisTemplate.keys("*");
        redisTemplate.delete(keys);
        log.info("已清除所有的redis缓存!");
    }
}
