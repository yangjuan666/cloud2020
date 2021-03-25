package com.guigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/23
 */

@RestController
@RequestMapping(value = "payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    @GetMapping(value = "/zk")
    public String zk(){
        return "springcloud with zookeeper: "+serverPort+" "+ UUID.randomUUID().toString();
    }

}