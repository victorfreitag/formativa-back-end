package com.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alunos.entities.Aluno;
import com.alunos.repository.AlunoRepository;

@Service
public class AlunoService {

private final AlunoRepository alunoRepository;
    
//Trocar "ProdutoRepository" para AlunoRepository,
//Trocar "turmaRepository" para alunoRepository,
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }//Trocar "ProdutoRepository" para AlunoRepository,
    	
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.orElse(null);
    }
    //Query Method 
    public List<Aluno> buscarAlunosPorCidade(String cidade) {
        return alunoRepository.findByCidade(cidade); 
      }
  //Query Method 
    public List<Aluno> findByRa(String ra) {
        return alunoRepository.findByCidade(ra); 
      }
    
    
    //Exluir todas as buscas inutil

    public Aluno salvarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }//salvar para save

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) { //alterar isPresente para isPresent
            updatedAluno.setId(id);
            return alunoRepository.save(updatedAluno);
        }
        return null;
    }

    public boolean deleteAluno(Long id) {
        Optional<Aluno> existingAluno = alunoRepository.findById(id);
        if (existingAluno.isPresent()) { //alterar isPresente para isPresent
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
