package com.projetofinal.repository;

import com.projetofinal.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
public interface NotaRepository extends JpaRepository <Nota, Long> {
    }
