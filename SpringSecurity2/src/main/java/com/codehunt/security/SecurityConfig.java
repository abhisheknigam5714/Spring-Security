package com.codehunt.security;

import java.net.http.HttpRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		http
		.authorizeHttpRequests()
		.antMatchers("/admin").hasRole("Admin")
		.antMatchers("/member").hasRole("member")
		.anyRequest().permitAll()
		.and()
		.httpBasic()
		.and()
		.exceptionHandling()
		.accessDeniedPage("/error");
		
		return http.build();
	}
	
	
	@Bean
	public AuthenticationManager manage(AuthenticationConfiguration auth) throws Exception {
		
		
		return auth.getAuthenticationManager();
	}
	
	
	
	
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}

}
