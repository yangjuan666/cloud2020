package com.guigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/25
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_guigu",r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("path_route_guigu2",r -> r.path("/guoji").uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }

}