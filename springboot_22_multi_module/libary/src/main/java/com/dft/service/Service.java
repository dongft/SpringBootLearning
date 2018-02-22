package com.dft.service;

import org.springframework.stereotype.Component;

@Component
public class Service {

    private final String message;

    public Service(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
