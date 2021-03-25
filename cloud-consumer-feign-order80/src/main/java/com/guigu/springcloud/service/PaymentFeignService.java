package com.guigu.springcloud.service;

import com.guigu.springcloud.model.CommonResult;
import com.guigu.springcloud.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/24
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult select(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    public String feignTimeOut();

}