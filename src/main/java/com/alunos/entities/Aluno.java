package com.alunos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 100)
    private Long id;
    //Adicionei Column//
    
    private String nome;
    private String ra;
    private String email;
    private String telefone;
    private String cidade;
    private double renda;
    
    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;
    
    //@JoinColumn no lugar do @Column, adcionei 'turma'//
    
}
