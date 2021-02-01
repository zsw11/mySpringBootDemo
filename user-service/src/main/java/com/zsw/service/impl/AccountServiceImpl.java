package com.zsw.service.impl;

import com.zsw.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zsw
 * @date 2021/1/29 16:04
 * @description :
 */
@Service
public interface AccountServiceImpl {
    public int add(String name, double money);
    public int update(String name, double money, int id);
    public int delete(int id);
    public Account findAccount(int id);
    public List<Account> findAccountList();
}
