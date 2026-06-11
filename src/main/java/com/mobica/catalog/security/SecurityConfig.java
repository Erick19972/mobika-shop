package com.mobica.catalog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/products/**").permitAll()
                        .requestMatchers("/api/cart/**").permitAll()
                        .requestMatchers("/graphql").permitAll()
                        .requestMatchers("/graphiql").permitAll()
                        .requestMatchers("/graphiql/**").permitAll()

                        // Permitir cualquier endpoint
                        .anyRequest().permitAll()
                );

        return http.build();
    }
}