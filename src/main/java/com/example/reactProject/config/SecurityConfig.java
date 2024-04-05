package com.example.reactProject.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(auth -> auth.disable())            // 괄호 안에 람다함수를 사용해야 함
                .headers(x -> x.frameOptions(y -> y.disable()))        // CK Editor image upload
                .authorizeHttpRequests(auth -> auth
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()         // 페이지 안에서 리턴으로 보내는 것(FORWARD)들은 전부 권한을 묻지 않겠다라는 뜻
                        .requestMatchers("/user/register",  "/react/**",       //"/user/login"
                                "/img/**", "/css/**", "/js/**", "/error/**").permitAll()            // 해당 경로 또는 아래있는 것들은 권한을 묻지 않겠다라는 뜻 permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")            // 해당 경로로 접근할 때 권한이 있는지 (ROLE_ADMIN) 를 확인하고 있으면 보내줌
                        .anyRequest().authenticated()       // 나머지 주소의 것들은 전부 권한을 묻겠다.없을시 로그인창으로
                );

        return http.build();
    }
}
