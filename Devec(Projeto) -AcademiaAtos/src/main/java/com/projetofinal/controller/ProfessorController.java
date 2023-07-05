package com.projetofinal.controller;

import com.projetofinal.model.Aluno;
import com.projetofinal.model.Professor;
import com.projetofinal.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/adicionarProfessor")
    public String adicionarProfessor(Model model) {
        model.addAttribute("professor", new Professor());
        return "professor/adicionarProfessor";
    }

    @PostMapping("/adicionarProfessor")
    public String adicionarProfessor(@ModelAttribute Professor professor, Model model) {
        professorRepository.save(professor);
        listarProfessor(model);
        return "professor/listarProfessor";
    }

    @GetMapping("/listarProfessor")
    public String listarProfessor(Model model) {
        List<Professor> lista = this.professorRepository.findAll();
        model.addAttribute("listarProfessor", lista);
        return "professor/listarProfessor";
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professorAtualizado) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado com o ID fornecido."));
        professor.setNome(professorAtualizado.getNome());
        professor.setCpf(professorAtualizado.getCpf());
        professor.setDisciplina(professorAtualizado.getDisciplina());
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void removerProfessor(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }
}