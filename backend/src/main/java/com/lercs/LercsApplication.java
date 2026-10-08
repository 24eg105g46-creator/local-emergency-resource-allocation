package com.lercs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@SpringBootApplication
@ConfigurationPropertiesScan
@OpenAPIDefinition(
        info = @Info(
                title = "LERCS API",
                version = "1.0",
                description = "Local Emergency Resource Coordination System REST API"
        ),
        security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class LercsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LercsApplication.class, args);
    }
}