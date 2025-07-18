package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceRoutes {
    @Bean
    public RouteLocator UserRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/auth-service/users/infor")
                        .and().method("GET")
                        .uri("http://localhost:8081"))

                .route(r -> r
                        .path("/auth-service/users/update-avatar")
                        .and().method("PUT")
                        .uri("http://localhost:8081"))

                .build();
    }
}
