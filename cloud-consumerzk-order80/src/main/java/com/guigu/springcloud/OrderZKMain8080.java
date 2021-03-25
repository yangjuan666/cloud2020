package com.guigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain8080.class,args);
    }
}