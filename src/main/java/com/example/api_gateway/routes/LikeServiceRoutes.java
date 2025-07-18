package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LikeServiceRoutes {
    @Bean
    public RouteLocator LikeLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route(r -> r
                        .path("/post-service/like/like")
                        .and().method("POST")
                        .uri("http://localhost:8082"))

                .route(r -> r
                        .path("/post-service/like/unlike")
                        .and().method("POST")
                        .uri("http://localhost:8082"))
                .route(r -> r
                        .path("/post-service/like/total/")
                        .and().method("GET")
                        .uri("http://localhost:8082"))

                .build();
    }
}
