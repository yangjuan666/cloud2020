package com.guigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/24
 */
public interface LoadBalancer {

    ServiceInstance instances(List<ServiceInstance> instanceList);

}