package com.guigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/24
 */
@Service
public class PaymentService {

    /**
     * 正常方法 OK
     */
    public String paymentInfo_OK(Integer id){
        return "线程池： " + Thread.currentThread().getName() +" paymentInfo_OK,id: "+id+"   哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfo_TimeOut(Integer id){
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName() +" paymentInfo_TimeOut,id: "+id+"   哈哈，耗时："+timeNumber+"秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName() +" 8001系统繁忙，请稍后重试,id: "+id+"   兜底啦";
    }



    //============服务熔断

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("**********id不能为负数");
        }

        String num = IdUtil.simpleUUID();

        return Thread.currentThread().getName() +" 调用成功,流水号: "+num;
    }

    public String paymentCircuitBreaker_fallback(Integer id){
        return "id不能为负数，请稍后重试,id: "+id;
    }

}