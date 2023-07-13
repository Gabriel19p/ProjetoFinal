package com.projetofinal.repository;

import com.projetofinal.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
    Optional<Aluno> findById(Long id);
}
