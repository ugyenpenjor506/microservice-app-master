package com.cloudgateway.service.config;

import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;


@Configuration
public class GatewayConfig {
	
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    	return builder.routes()
       		 .route(r -> r.path("/auth/**")
       				 	.filters(f -> f.circuitBreaker(c -> c.setName("fallback_auth").setFallbackUri("/authfallback")))
                        .uri("http://localhost:2000/")
                       )
       		 .route(r -> r.path("/microservice1/**")
       				    .filters(f -> f.circuitBreaker(c -> c.setName("fallback_ms1").setFallbackUri("/fallback1")))
                        //.uri("http://localhost:9091/")  //With service discovery
       				    .uri("lb://MICROSERVICE-ONE/")        //without service discovery
                       )
       		 .route(r -> r.path("/microservice2/**")
       				 	.filters(f -> f.circuitBreaker(c -> c.setName("fallback_ms2").setFallbackUri("/fallback2")))
                        .uri("http://localhost:4000/")
                       )
       		      
                .build();    
        
    }
    
    @Bean
    public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer()
    {
        return factory->factory.configureDefault(id ->new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
                .timeLimiterConfig(TimeLimiterConfig.custom()
                        .timeoutDuration(Duration.ofSeconds(2)).build()).build());
    }
}
