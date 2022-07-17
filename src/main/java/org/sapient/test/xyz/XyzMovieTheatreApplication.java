package org.sapient.test.xyz;

import org.sapient.test.xyz.contant.ApplicationConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@SpringBootApplication
@EnableSwagger2
public class XyzMovieTheatreApplication {

    public static void main(String[] args) {
        SpringApplication.run(XyzMovieTheatreApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage(ApplicationConstants.CONTROLLER_BASE_PACKAGE)).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(ApplicationConstants.APPLICATION_TITLE,
                ApplicationConstants.APPLICATION_DESCRIPTION, ApplicationConstants.APPLICATION_DOCUMENTATION_VERSION,
                ApplicationConstants.APPLICATION_TERMS_OF_SERVICE_URL, ApiInfo.DEFAULT_CONTACT,
                ApplicationConstants.APPLICATION_LICENSE, ApplicationConstants.APPLICATION_LICENSE_URL,
                new ArrayList());
    }

}
