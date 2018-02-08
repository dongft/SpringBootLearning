package com.dft.service;

import com.dft.AccountMapper;
import com.dft.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AccountService {

    @Resource
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    public int updateAccount(int id, String name, double money) {
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

    @Transactional
    public void transfer() throws RuntimeException{
        accountMapper.update(1,90);//用户1减10块 用户2加10块
        int i=1/0;
        accountMapper.update(2,110);
    }
}
