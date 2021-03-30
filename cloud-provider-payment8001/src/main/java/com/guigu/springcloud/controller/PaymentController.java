package com.guigu.springcloud.controller;

import com.guigu.springcloud.model.CommonResult;
import com.guigu.springcloud.model.Payment;
import com.guigu.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/19
 */
@RestController
@Slf4j
@RequestMapping(value = "/payment")
@Api(description = "支付模块",value = "",tags = "")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     *  @RequestBody  记得加，不然 consumer8080 调用到这边参数为空
     */
    @PostMapping(value = "/create")
    @ApiOperation(value = "新增")
    public CommonResult create(@RequestBody Payment payment){
        boolean result = paymentService.save(payment);
        log.info("****插入结果" + result);
        if(result){
            return new CommonResult(200,"插入成功,serverPort: "+serverPort);
        }
        return new CommonResult(444,"插入失败");
    }

    @GetMapping(value = "/get/{id}")
    @ApiOperation(value = "查询")
    public CommonResult select(@PathVariable("id") Long id){
        Payment result = paymentService.getById(id);
        log.info("****查询结果" + result);
        System.out.println("测试热部署");
        if(result == null){
            return new CommonResult(444,"查询失败");
        }
        return new CommonResult(200,"查询成功,serverPort: "+serverPort,result);
    }

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services) {
            log.info("****element: "+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances) {
            log.info(instance.getServiceId()+"/t"+instance.getHost()+"/t"+instance.getPort()+"/t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String feignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping(value = "/zipkin")
    public String paymentZipkin(){
        return "i am paymentZipkin , ha ha ha ...";
    }
}