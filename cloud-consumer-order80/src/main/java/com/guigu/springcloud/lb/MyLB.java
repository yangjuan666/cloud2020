package com.guigu.springcloud.lb;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancer;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangjuan
 * @description  模拟轮询
 * @date 2021/3/24
 *
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0) ;

    public final int getAndIncrement(){
        int current;
        int next;

        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));

        //TODO
//        AtomicInteger 和 compareAndSet


        System.out.println("*********第几次访问，次数next: "+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instanceList) {
        int index = getAndIncrement()%instanceList.size();
        return instanceList.get(index);
    }
}