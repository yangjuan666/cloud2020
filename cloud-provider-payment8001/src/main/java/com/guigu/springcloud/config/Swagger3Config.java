package com.guigu.springcloud.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author yangjuan
 * @description
 * @date 2021/3/22
 */

@Configuration
@Slf4j
// 原来的@EnableSwagger2去掉
public class Swagger3Config {
    @Bean
    public Docket createRestApi() {

        log.info("加载Swagger3");

        return new Docket(DocumentationType.OAS_30) // 注意此处改动，需要将SWAGGER_2改成OAS_30
                .apiInfo(apiInfo()).select()
                // 扫描所有有注解的api，用这种方式更灵活
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger3接口文档")
                .description("接口文档")
                .contact(new Contact("羊羊羊", "#", "#"))
                .version("0.1.0")
                .build();
    }
}