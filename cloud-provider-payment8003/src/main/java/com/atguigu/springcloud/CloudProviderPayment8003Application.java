package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudProviderPayment8003Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8003Application.class, args);
    }
}
