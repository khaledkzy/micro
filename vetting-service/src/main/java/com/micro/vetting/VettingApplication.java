package com.micro.vetting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VettingApplication {
    public static void main(String[] args) {

        SpringApplication.run(VettingApplication.class, args);
    }
}