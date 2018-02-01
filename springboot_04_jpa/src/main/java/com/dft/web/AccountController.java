package com.dft.web;

import com.dft.dao.AccountDAO;
import com.dft.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccoutList() {
        return accountDAO.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable int id) {
        return accountDAO.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam("name") String name,
                                @RequestParam("money") double money) {
        if (null == getAccountById(id)) {
            return "invalid id " + id;
        }
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setMoney(money);

        Account account1 = accountDAO.saveAndFlush(account);

        return account1.toString();
    }
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String updateAccount(@RequestParam("id") int id, @RequestParam("name") String name,
//                                @RequestParam("money") double money) {
//        Account account = new Account();
//        account.setId(id);
//        account.setName(name);
//        account.setMoney(money);
//
//        Account account1 = accountDAO.saveAndFlush(account);
//
//        return account1.toString();
//    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addAccount(@RequestParam("name") String name, @RequestParam("money") double
            money) {
        Account account = new Account();
        account.setName(name);
        account.setMoney(money);

        Account account1 = accountDAO.save(account);

        return account1.toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public void deleteAccount(@PathVariable("id") int id) {
        accountDAO.delete(id);
    }
}
