package com.alunos;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@EnableWebSecurity
@SpringBootApplication
public class TurmaAluno1Application {

	public static void main(String[] args) {
		SpringApplication.run(TurmaAluno1Application.class, args);
	}

}
