package com.alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunos.entities.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	//torcar turmarepository para Turma

}
