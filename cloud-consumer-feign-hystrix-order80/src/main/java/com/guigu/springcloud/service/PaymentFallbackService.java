package com.guigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/25
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "---------PaymentFallbackService  fall back paymentInfo_OK-----------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "---------PaymentFallbackService  fall back paymentInfo_TimeOut-----------";
    }
}