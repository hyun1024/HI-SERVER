package com.teamh.hiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HiServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HiServerApplication.class, args);
    }

}
