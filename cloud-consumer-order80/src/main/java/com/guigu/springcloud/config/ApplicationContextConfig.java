package com.guigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/22
 */
@Configuration
public class ApplicationContextConfig {

    /**
     * @LoadBalanced 赋予了RestTemplate 负载均衡的能力
     */
    @Bean
//    @LoadBalanced
    public RestTemplate getRestTemple(){
        return new RestTemplate();
    }
}