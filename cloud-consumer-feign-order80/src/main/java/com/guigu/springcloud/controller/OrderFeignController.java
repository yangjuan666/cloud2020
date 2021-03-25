package com.guigu.springcloud.controller;

import com.guigu.springcloud.model.CommonResult;
import com.guigu.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/24
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult select(@PathVariable("id") Long id){
        return paymentFeignService.select(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String timeout(){
        //openfeign-rabbion 客户端一般默认等待1s
        return paymentFeignService.feignTimeOut();
    }
}