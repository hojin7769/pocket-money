package com.aws.pocketmoney.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecuriryConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http){
        try{
            return http
                    .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                    .formLogin().and()
                    .build();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
