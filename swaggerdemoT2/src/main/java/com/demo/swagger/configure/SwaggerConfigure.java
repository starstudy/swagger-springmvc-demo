package com.demo.swagger.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
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
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfigure {

    /**
     * Package设置
     */
    private static String PACKAGE_MODULE_A = "com.demo.swagger.controller.modulea"; //Module A
    private static String PACKAGE_MODULE_B = "com.demo.swagger.controller.moduleb"; //Module A

    /**
     * GroupName
     */
    private static String GROUP_MODULE_A = "modulea"; //Module A
    private static String GROUP_MODULE_B = "moduleb"; //Module A



    /**
     * 对于模块A的Docket定义
     * @return
     */
    @Bean
    public Docket apiModuleA() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_MODULE_A) //命名组名
                .apiInfo(apiInfoModuleA())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_MODULE_A))
                .build();
    }

    /**
     * Module A 的接口信息
     * @return
     */
    private ApiInfo apiInfoModuleA(){
        return new ApiInfoBuilder()
                .title("这是一个swagger demo - 基于第二种方式")
                .description("springmvc swagger2 - ModuleA")
                .contact(new Contact("demo", "", "demo@xx.com"))
                .build();
    }

    /**
     * 对于模块A的Docket定义
     * @return
     */
    @Bean
    public Docket apiModuleB() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(GROUP_MODULE_B) //命名组名
                .apiInfo(apiInfoModuleB())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_MODULE_B))
                .build();
    }

    /**
     * Module A 的接口信息
     * @return
     */
    private ApiInfo apiInfoModuleB(){
        return new ApiInfoBuilder()
                .title("这是一个swagger demo - 基于第二种方式")
                .description("springmvc swagger2 - ModuleB")
                .contact(new Contact("demo", "", "demo@xx.com"))
                .build();
    }
}
