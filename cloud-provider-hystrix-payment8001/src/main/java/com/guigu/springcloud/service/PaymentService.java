package com.guigu.springcloud.service;

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
}