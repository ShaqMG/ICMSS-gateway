package com.example.icmssgateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class MyFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin","*");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Credentials","true");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE");
        exchange.getResponse().getHeaders().add("Access-Control-Allow-Headers","*");
        exchange.getResponse().getHeaders().add("Access-Control-Max-Age","3600");
        return chain.filter(exchange);
    }
}
