package com.codehunt.security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
/*	
	@Bean
	public AuthenticationProvider provider() {
		 DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		 dao.setUserDetailsService(service());
		 dao.setPasswordEncoder(encode());
		return dao;
	}
	
	*/
	
	
	/*@Bean UserDetailsService service() {
		

		InMemoryUserDetailsManager in = new InMemoryUserDetailsManager();
		in.createUser(
				User
				.withUsername("admin")
				.password(encode().encode("admin123"))
				.roles("Admin")
				.build()
				
				);
		
		
		in.createUser(
				
				User
				.withUsername("member")
				.password(encode().encode("member123"))
				.roles("Member")
				.build()
				
				);
		return in;
	}
	*/
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.antMatchers("/admin").authenticated()
		.antMatchers("/member").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/admin")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/error")
		.and()
		.logout()
		.logoutUrl("/dologout");
		
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
