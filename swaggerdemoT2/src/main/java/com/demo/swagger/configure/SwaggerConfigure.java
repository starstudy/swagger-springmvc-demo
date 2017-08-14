package com.demo.swagger.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sxx
 * @brief swagger加载的配置的声明类
 * @details
 * @date 2017-08-09 18:38
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigure {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("这是一个swagger demo - 基于第二种方式")
                .description("springmvc swagger2")
                .contact(new Contact("demo", "", "demo@xx.com"))
                .build();

    }

}
