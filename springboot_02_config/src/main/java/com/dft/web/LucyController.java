package com.dft.web;

import com.dft.bean.ConfigBean;
import com.dft.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableConfigurationProperties({ConfigBean.class, User.class})
public class LucyController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/lucy")
    public String lucy() {
        return configBean.getGreeting() + " >>>>" + configBean.getName() + " >>>>" + configBean
                .getUuid() + " >>>>" + configBean.getMax();
    }

    @Autowired
    User user;

    @RequestMapping(value = "/user")
    public String user() {
        return user.getName() + "-" + user.getAge();
    }
}
