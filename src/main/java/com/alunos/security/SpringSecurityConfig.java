package com.alunos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		.csrf().disable()
		.authorizeHttpRequests((requests)-> requests

				.requestMatchers(
						"/v3/api-docs/**",
	                    "/swagger-ui/**",
	                    "/swagger-ui/index.html")
				
				//ui para ui/index.html, nao tem **,
				.permitAll()
				
				.requestMatchers(
						HttpMethod.POST,"/aluno/", "/turma/")
				.authenticated()
				
				//permitAll para .authenticated()
				
				.requestMatchers(
						HttpMethod.GET,"/aluno/", "/turma/")
				.permitAll()
				
				.requestMatchers(
						HttpMethod.DELETE,"/aluno/{id}", "/turma/{id}")//adicionar {id}
				.authenticated()
				//permitAll para .authenticated()
				
				.requestMatchers(
						HttpMethod.PUT,"/turma/{id}")
				.authenticated()
				
				.anyRequest()
				.denyAll()		
				
				
				//adicionar denyAll
				

				)
		.httpBasic();
		return http.build();

	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService(){
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("adriano")
				.password("senai")
				.build();
		return new InMemoryUserDetailsManager(user);

	}

}



