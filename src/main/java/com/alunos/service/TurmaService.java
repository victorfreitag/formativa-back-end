package com.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alunos.entities.Turma;
import com.alunos.repository.TurmaRepository;

@Service
public class TurmaService {
	
	  private final TurmaRepository turmaRepository;
	  @Autowired
	  
	  // trocar alunoRepository para turmaRepository
	    
	    public TurmaService(TurmaRepository turmaRepository) {
	        this.turmaRepository = turmaRepository;
	    }

	    public List<Turma> getAllTurma() {
	        return turmaRepository.findAll();
	    }
	    	//trocar TurmaService para Turma
	    public Turma getTurmaById(Long id) {
	        Optional<Turma> turma = turmaRepository.findById(id);
	        return turma.orElse(null);
	    }

	    public Turma salvarTurma(Turma turma) {
	        return turmaRepository.save(turma);
	    }
	    //salvar para save, TurmaService para Turma//

	    public Turma updateTurma(Long id, Turma updatedTurma) {
	        Optional<Turma> existingTurma = turmaRepository.findById(id);
	        if (existingTurma.isPresent()) { 
	            updatedTurma.setId(id);
	            return turmaRepository.save(updatedTurma);
	        }
	        return null;
	    }
	    //trocar TurmaService para Turma,alterar isPresente para isPresent

	    public boolean deleteTurma(Long id) {
	        Optional<Turma> existingTurma = turmaRepository.findById(id);
	        if (existingTurma.isPresent()) { //alterar isPresente para isPresent
	            turmaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}
