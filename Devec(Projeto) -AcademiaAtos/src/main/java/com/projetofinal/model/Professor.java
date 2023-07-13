package com.projetofinal.model;

import jakarta.persistence.*;

@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cpf;
    private String nome;

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
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;

    }

    public Professor(String cpf, String nome) {
        super();
        this.cpf = cpf;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor [id=" + id + ", Nome=" + nome + "]";
    }

    public Professor() {
        super();
    }

}


