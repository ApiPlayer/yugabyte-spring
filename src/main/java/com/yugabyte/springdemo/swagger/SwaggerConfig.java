package com.yugabyte.springdemo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.Collections;

@EnableSwagger2
@Configuration
public class SwaggerConfig
{
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.yugabyte"))
            .paths(regex("/lists.*"))
            .build().apiInfo(metaInfo());

    }
    private ApiInfo metaInfo() {

        ApiInfo apiInfo=new ApiInfo("ShoppingList Api", "ShoppingList Api methods", "1.0", "Terms of Service", new Contact("Chloe", "url", "email"), "License for ShoppingList ", "Url of ShoppingList", Collections.EMPTY_LIST);

        return apiInfo;
    }
}
