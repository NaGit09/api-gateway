package com.example.api_gateway.utils;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {
    private static final List<String> openApiEndpoints = List.of(
            "/auth-service/auth/login",
            "/auth-service/auth/register",
            "/auth-service/auth/refresh-token",
            "/auth-service/auth/infor"
    );


    public Predicate<ServerHttpRequest> isSecured = request ->
            openApiEndpoints.stream().noneMatch(uri -> request.getURI().getPath().startsWith(uri));

}
