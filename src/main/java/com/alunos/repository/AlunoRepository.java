package com.alunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunos.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	//Aluno Repository no lugar de ProdutoRepository//
	
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByRa(String ra);
	
	//trocar Aluno findByRa(String ra) para

}
