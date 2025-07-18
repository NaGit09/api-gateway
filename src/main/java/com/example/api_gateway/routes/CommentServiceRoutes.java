package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommentServiceRoutes {
    @Bean
    public RouteLocator CommentRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r
                        .path("/post-service/comments/create")
                        .and().method("POST")
                        .uri("http://localhost:8082"))

                .route(r -> r
                        .path("post-service/comments/update")
                        .and().method("PUT")
                        .uri("http://localhost:8082"))

                .route(r -> r
                        .path("post-service/comments/delete/")
                        .and().method("DELETE")
                        .uri("http://localhost:8082"))

                .route(r -> r
                        .path("post-service/comments/all/")
                        .and().method("GET")
                        .uri("http://localhost:8082"))

                .route(r -> r
                        .path("post-service/comments/replies/")
                        .and().method("GET")
                        .uri("http://localhost:8082"))

                .route(r -> r
                        .path("post-service/comments/total/")
                        .and().method("GET")
                        .uri("http://localhost:8082"))

                .route(r -> r
                        .path("post-service/comments/total-replies/")
                        .and().method("GET")
                        .uri("http://localhost:8082"))

                .build();
    }
}
