package com.projetofinal.model;

import jakarta.persistence.*;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String matricula;
    private String CPF;

    // Construtores

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) {
        this.CPF = cpf;
    }

    public Aluno(String matricula, String nome, String CPF) {
        super();
        this.matricula = matricula;
        this.nome = nome;
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Aluno [id=" + id + ", Matrícula=" + matricula + ", nome=" + nome + "]";
    }

    public Aluno() {
        super();
    }

}
