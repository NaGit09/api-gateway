package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostServiceRoutes {
    @Bean
    public RouteLocator PostLocator(RouteLocatorBuilder builder) {
        return  builder.routes()

                .route( (r -> r
                        .path("/post-service/posts/create")
                        .and().method("POST")
                        .uri("http://localhost:8082")))

                .route( (r -> r
                        .path("/post-service/posts/update")
                        .and().method("PUT")
                        .uri("http://localhost:8082")))

                .route( (r -> r
                        .path("/post-service/posts/delete/")
                        .and().method("POST")
                        .uri("http://localhost:8082")))

                .route( (r -> r
                        .path("/post-service/posts/")
                        .and().method("GET")
                        .uri("http://localhost:8082")))

                .build();
    }
}
