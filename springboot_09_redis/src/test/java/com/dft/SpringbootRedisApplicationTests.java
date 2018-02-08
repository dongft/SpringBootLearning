package com.dft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    public static org.slf4j.Logger logger = LoggerFactory.getLogger(SpringBootRedisApplication.class);

    @Test
    public void contextLoades() {
    }

    @Autowired
    RedisDAO redisDAO;

    @Test
    public void testRedis(){
        redisDAO.setKey("n1","王尼玛");
        redisDAO.setKey("n2","王大锤");
        logger.info("n1:{}",redisDAO.getValue("n1"));
        logger.info("n2:{}",redisDAO.getValue("n2"));
    }
}
