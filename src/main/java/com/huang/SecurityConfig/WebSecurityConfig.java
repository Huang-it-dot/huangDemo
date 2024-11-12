package com.huang.SecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;





@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	
	
//	private final CustomUserDetailsService customUserDetailsService;
//	
//	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
//		this.customUserDetailsService = customUserDetailsService;
//	}
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers("/").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/signIn")
				.permitAll()
				.defaultSuccessUrl("/home", true)
				
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
//	@Bean
//	PasswordEncoder passwordEncoder() {
//        // This will store passwords in plain text
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//	
//	@Bean
//    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                   .userDetailsService(customUserDetailsService)
//                   .passwordEncoder(passwordEncoder())
//                   .and()
//                   .build();
//    }
//	
	
	
	
}