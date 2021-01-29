package com.zsw.service;

import com.zsw.dao.AccountMapper;
import com.zsw.entity.Account;
import com.zsw.service.impl.AccountServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsw
 * @date 2021/1/29 16:02
 * @description :
 */
@Service
public class AccountService implements AccountServiceImpl {
    @Resource
    private AccountMapper accountMapper;

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
        return accountMapper.findAccount(id);
    }
    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }
}
