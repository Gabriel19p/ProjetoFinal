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

        @GetMapping("/alterarProfessor/{id}")
    public String alterarProfessor(@PathVariable Long id, Model model) {
        Professor professor = professorRepository.findById(id).get();
        model.addAttribute("professor",professor);
        return"professor/alterarProfessor";
    }

    @PostMapping("/alterarProfessor/{id}")
        public String alterarProfessor(@ModelAttribute Professor professor,Model model) {
        professorRepository.save(professor);
        listarProfessor(model);
        return "professor/listarProfessor";
    }

    @GetMapping("/excluirProfessor/{id}")
    public String excluirProfessor(@PathVariable("id") Long id, Model model) {
        professorRepository.deleteById(Long.valueOf(String.valueOf(id)));
        listarProfessor(model);
        return "professor/listarProfessor";
    }
    @PostMapping ("/excluirProfessor/{id}")
    public String excluirProfessor(@ModelAttribute Professor professor,Model model) {
        professorRepository.save(professor);
        listarProfessor(model);
        return "professor/listarProfessor";
    }
}
