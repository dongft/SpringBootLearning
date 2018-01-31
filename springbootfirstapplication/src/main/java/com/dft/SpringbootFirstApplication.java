package com.dft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootFirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFirstApplication.class, args);
    }

    //    @Bean
    //    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    //        return args -> {
    //            System.out.println("Let's inspect the beans provided by spring boot:");
    //
    //            String[] beanNames = ctx.getBeanDefinitionNames();
    //            Arrays.sort(beanNames);
    //            for (String bean : beanNames) {
    //                System.out.println(bean);
    //            }
    //        };
    //    }
}
