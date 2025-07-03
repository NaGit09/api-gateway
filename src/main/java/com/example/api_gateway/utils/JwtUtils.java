package com.example.api_gateway.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    @Value("${jwt.key}")
    private String SECRET_KEY;

    public boolean validateToken(String token) {
        try {
            getClaims(token);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String getUserIdFromToken(String token) {
        return getClaims(token).getSubject();
    }

    public String getRolesFromToken(String token) {
        Object roleObj = getClaims(token).get("roles");
        return (roleObj instanceof String) ? (String) roleObj : null;
    }
    public List<String> getPermissionsFromToken(String token) {
        Claims claims = getClaims(token);
        Object raw = claims.get("permissions");

        if (raw instanceof List<?> list) {
            return list.stream()
                    .map(Object::toString) // ép từng phần tử về String
                    .collect(Collectors.toList());
        }
        return List.of(); // hoặc throw nếu bạn muốn bắt lỗi
    }


    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
