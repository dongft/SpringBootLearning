package com.dft.service;

import com.dft.dao.AccountMapper;
import com.dft.entity.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    public int update(int id, String name, double money) {
        return accountMapper.updateAccount(id, name, money);
    }

    public int delete(int id) {
        return accountMapper.deleteAccountById(id);
    }

    public Account getAccountById(int id) {
        return accountMapper.getAccountById(id);
    }

    public List<Account> getAllAccount() {
        return accountMapper.getAllAccount();
    }
}
