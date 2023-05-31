package com.idol.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info()
                .title("Idol Api Test")
                .description("")
                .version("")
                .termsOfService("")
                .contact(new Contact().name("")
                        .url("")
                        .email(""))
                .license(new License().name("")
                        .url("")));
    }
}
