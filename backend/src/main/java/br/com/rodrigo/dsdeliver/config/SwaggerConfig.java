package br.com.rodrigo.dsdeliver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }


    private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.basePackage("br.com.rodrigo.dsdeliver.controller")::apply;
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo;
        apiInfo = new ApiInfoBuilder()
                .title ("API DSDeliver")
                .description ("Essa é a API de Entrega de comidas.")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .termsOfServiceUrl("/service.html")
                .version("1.0.0")
                .contact(new Contact("Rodrigo Oliveira","https://github.com/tigelah", "rodrigoabreuoli@hotmail.com.br"))
                .build();

        return apiInfo;
    }
}
