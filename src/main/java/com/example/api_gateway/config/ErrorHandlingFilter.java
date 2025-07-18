package com.example.api_gateway.config;
import com.example.api_gateway.dto.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;
import org.springframework.core.io.buffer.DataBuffer;

import java.nio.charset.StandardCharsets;

@Component
public class ErrorHandlingFilter implements GatewayFilter {

    private final ObjectMapper objectMapper = new ObjectMapper(); // Jackson

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange)
                .onErrorResume(throwable -> handleException(exchange, throwable));
    }

    private Mono<Void> handleException
            (ServerWebExchange exchange, Throwable throwable) {

        HttpStatusCode status = HttpStatus.INTERNAL_SERVER_ERROR;
        String message = "Internal Server Error";

        if (throwable instanceof ResponseStatusException ex) {
            status = ex.getStatusCode();
            message = ex.getReason() != null ? ex.getReason() : ex.getMessage();
        }

        // Tạo object response
        ErrorResponse errorResponse = new ErrorResponse(status.value(), message);

        // Convert object sang JSON string
        String body;
        try {
            body = objectMapper.writeValueAsString(errorResponse);
        } catch (Exception e) {
            body = "{\"code\":400,\"message\":\"Unknown Error\"}";
        }

        // Trả về response
        exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(body.getBytes(StandardCharsets.UTF_8));
        return exchange.getResponse().writeWith(Mono.just(buffer));
    }
}

