package com.alunos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alunos.entities.Aluno;
import com.alunos.service.AlunoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping
public class AlunoController {

	 private final AlunoService alunoService;
	    
	    @Autowired
	    public AlunoController(AlunoService alunoService) {
	        this.alunoService = alunoService;
	    }
	    //Query Method
	    @GetMapping("/cidade/{cidade}")
	    @Operation(summary = "Localiza o aluno por Cidade")
	    public ResponseEntity<List<Aluno>> buscarAlunosPorCidade(@PathVariable String cidade) {
	      List<Aluno> alunos = alunoService.buscarAlunosPorCidade(cidade);
	      return ResponseEntity.ok(alunos);
	    }
	    //Query Method
	    @GetMapping("/ra/{ra}")
	    public ResponseEntity<List<Aluno>> findByRa(@PathVariable String ra) {
	      List<Aluno> alunos = alunoService.findByRa(ra);
	      return ResponseEntity.ok(alunos);
	    }
	    
	    //Adicionar Query para Ra


	    @GetMapping("/{id}")
	    public ResponseEntity<Aluno> getProductById(@PathVariable Long id) {
	        Aluno aluno = alunoService.getAlunoById(id);
	        if (aluno != null) {
	            return ResponseEntity.ok(aluno);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    
	    public ResponseEntity<List<Aluno>> getAllAlunos() {
	        List<Aluno> alunos = alunoService.getAllAlunos();
	        return ResponseEntity.ok(alunos);
	    }

	    @PostMapping("/")
	    public ResponseEntity<Aluno> criarAluno(@RequestBody @Valid Aluno aluno) {
	        Aluno criarAluno = alunoService.salvarAluno(aluno);
	        return ResponseEntity.status(HttpStatus.CREATED).body(criarAluno);
	    }
	   

	    @PutMapping("/{id}")
	    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
	        Aluno updatedAluno = alunoService.updateAluno(id, aluno);
	        if (updatedAluno != null) {
	            return ResponseEntity.ok(updatedAluno);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Aluno> deleteAluno(@PathVariable Long id) {
	        boolean deleted = alunoService.deleteAluno(id);
	        if (deleted) {
	        	 return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); 
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	       
	 }


