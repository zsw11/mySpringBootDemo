package com.zsw.service.impl;

import com.zsw.dao.AccountMapper;
import com.zsw.model.Account;
import com.zsw.service.AccountService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zsw
 * @date 2021/1/29 16:02
 * @description :
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private RedisTemplate redisTemplate;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findAccount(int id) {
        Account account = accountMapper.findAccount(id);
        redisTemplate.opsForSet().add("account"+id,account.toString()); //redis缓存
        redisTemplate.expire("account" + id, 3, TimeUnit.HOURS);
        return account;
    }
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
