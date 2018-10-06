package com.dft;

import com.dft.service.Service;
import com.dft.service.ServiceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import(ServiceConfiguration.class)
@RestController
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class);
    }

    private final Service service;

    @Autowired
    public Application(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return service.getMessage();
    }
}
