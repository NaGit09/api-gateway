package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FollowServiceRoutes {
    @Bean
    public RouteLocator FollowRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()

                .route( r -> r
                        .path("/auth-service/follows/follows")
                        .and().method("POST")
                        .uri("http://localhost:8081"))

                .route( r -> r
                        .path("/auth-service/follows/unfollow")
                        .and().method("POST")
                        .uri("http://localhost:8081"))

                .route( r -> r
                        .path("/auth-service/follows/followers")
                        .and().method("GET")
                        .uri("http://localhost:8081"))

                .route( r -> r
                        .path("/auth-service/follows/followings/")
                        .and().method("GET")
                        .uri("http://localhost:8081"))
                .build();
    }
}
