package com.guigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjuan
 * @description @RefreshScope 动态刷新配置文件
 * @date 2021/3/26
 */
@RestController
@RefreshScope
public class ConfigClientController {


    /**
     * github配置文件修改，config服务端立马生效，客户端需要配置一些信息，然后发送个post请求才管用
     * 配置完并不生效，必须发送  curl -X POST "http://localhost:3355/actuator/refresh"
     * bus 向server发送  curl -X POST "http://localhost:3344/actuator/bus-refresh"
     * 定点通知   curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355"
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}