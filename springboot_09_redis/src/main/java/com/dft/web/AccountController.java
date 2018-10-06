package com.dft.web;

import com.dft.entity.Account;
import com.dft.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountService.getAccountById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateAccount(@PathVariable("id") int id, @RequestParam("name") String name,
                                 @RequestParam("money") double money) {
        int result = accountService.updateAccount(id, name, money);
        if (result == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addAccount(@RequestParam("name") String name, @RequestParam("money") double
            money) {
        int result = accountService.add(name, money);
        if (result == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("id") int id) {
        int result = accountService.delete(id);
        if (result == 1) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/transfer", method = RequestMethod.GET)
    public void transfer() {
        accountService.transfer();
    }
}
