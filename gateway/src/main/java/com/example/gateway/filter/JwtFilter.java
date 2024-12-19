package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtFilter extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return (ServerWebExchange exchange, GatewayFilterChain chain) -> {
            HttpHeaders headers = exchange.getRequest().getHeaders();

            // Vérifie si le token JWT est présent
            if (!headers.containsKey(HttpHeaders.AUTHORIZATION)) {
                throw new RuntimeException("Missing Authorization header");
            }

            String token = headers.getFirst(HttpHeaders.AUTHORIZATION).replace("Bearer ", "");

            // Ajouter ici la logique pour valider le JWT
            // Exemple : jwtUtil.isTokenValid(token)

            return chain.filter(exchange);
        };
    }
}
