package com.example.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostServiceRoutes {
    public RouteLocator PostLocator(RouteLocatorBuilder builder) {
        return  builder.routes().route( (r ->
                r.path("/post/create").and().method("").uri("http://localhost:8081")))



                .build();
    }
}
