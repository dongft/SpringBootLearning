package com.dft;

import com.dft.entity.User;
import com.dft.service.GithubLookupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(AppRunner.class);

    private final GithubLookupService githubLookupService;

    public AppRunner(GithubLookupService githubLookupService) {
        this.githubLookupService = githubLookupService;
    }

    @Override
    public void run(String... args) throws Exception{
        // start the clock
        long start = System.currentTimeMillis();

        //Kick of multiple,asynchronous looking up
        Future<User> page1 = githubLookupService.findUser("PivotalSoftware");
        Future<User> page2 = githubLookupService.findUser("CloudFoundry");
        Future<User> page3 = githubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        while (!(page1.isDone()&&page2.isDone()&&page3.isDone())){
            Thread.sleep(10); //10-millisecond pause between each check
        }

        // Print results, including elapsed time
        log.info("Elapsed time:"+(System.currentTimeMillis()-start));
        log.info("--> "+page1.get());
        log.info("--> "+page2.get());
        log.info("--> "+page3.get());
    }
}
