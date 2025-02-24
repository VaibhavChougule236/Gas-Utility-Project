package com.GasUtility.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/requests/**", "/customers/**").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(login -> login
                .defaultSuccessUrl("/requests", true)
            )
            .logout(logout -> logout.logoutSuccessUrl("/login?logout"));

        return http.build();
    }
}
