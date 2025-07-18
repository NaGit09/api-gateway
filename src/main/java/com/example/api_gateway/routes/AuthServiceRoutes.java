package com.example.api_gateway.routes;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AuthServiceRoutes {
    @Bean
    public RouteLocator AuthRouteLocator
            (RouteLocatorBuilder builder) {

        return builder.routes()

                .route(r -> r
                        .path("/auth-service/auth/register")
                        .and().method("POST")
                        .uri("http://localhost:8081"))

                .route(r -> r
                        .path("/auth-service/auth/login")
                        .and().method("POST")
                        .uri("http://localhost:8081"))

                .route(r -> r
                        .path("/auth-service/auth/refresh-token")
                        .and().method("POST")
                        .uri("http://localhost:8081"))

                .route(r -> r
                        .path("/auth-service/auth/logout")
                        .and().method("POST")
                        .uri("http://localhost:8081"))

                .build();
    }

}
