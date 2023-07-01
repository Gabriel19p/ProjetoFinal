package com.projetofinal.model;

import jakarta.persistence.*;
@Entity
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nota;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;
    }
