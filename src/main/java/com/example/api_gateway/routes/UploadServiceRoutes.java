package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadServiceRoutes {
    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/upload-service/upload/files")
                        .and().method("POST")
                        .uri("http://localhost:8082"))

                .route(r -> r.path("/upload-service/upload/delete-all")
                        .and().method("DELETE")
                        .uri("http://localhost:8082"))


                .route(r -> r.path("/upload-service/upload/update-draft")
                        .and().method("PUT")
                        .uri("http://localhost:8082"))

                .route(r -> r.path("/upload-service/upload/delete-draft")
                        .and().method("GET")
                        .uri("http://localhost:8082"))


                .build();
    }
}
