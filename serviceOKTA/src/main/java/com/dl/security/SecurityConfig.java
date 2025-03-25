package com.dl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/saml2/**", "/logout").permitAll()
                .anyRequest().authenticated()
                .and()
            .saml2Login()
                .defaultSuccessUrl("/home", true) //
                .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/") // Redirect after logout
                .invalidateHttpSession(true)
                .clearAuthentication(true);

        return http.build();
    }
}
