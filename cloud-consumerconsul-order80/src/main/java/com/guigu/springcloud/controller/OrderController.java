package com.guigu.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/24
 */
@RestController
public class OrderController {

    private static final String URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String order(){
        return restTemplate.getForObject(URL+"/payment/consul",String.class);
    }
}