package com.projetofinal.controller;

import com.projetofinal.model.Aluno;
import com.projetofinal.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/adicionarAluno")
    public String adicionarAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "aluno/adicionarAluno";
    }

    @PostMapping("/adicionarAluno")
    public String adicionarAluno(@ModelAttribute Aluno aluno, Model model) {
        alunoRepository.save(aluno);
        listarAluno(model);
        return "aluno/listarAluno";
    }

    @GetMapping("/listarAluno")
    public String listarAluno(Model model) {
        List<Aluno> lista = this.alunoRepository.findAll();
        model.addAttribute("listarAluno", lista);
        return "aluno/listarAluno";
    }

    @GetMapping("/alterarAluno/{id}")
    public String alterarAluno(@PathVariable Long id, Model model) {
        Aluno aluno = alunoRepository.findById(id).get();
        model.addAttribute("aluno",aluno);
        return "aluno/alterarAluno";
    }

    @PostMapping("/alterarAluno/{id}")
    public String alterarAluno(@ModelAttribute Aluno aluno,Model model) {
        alunoRepository.save(aluno);
        listarAluno(model);
        return "aluno/listarAluno";
    }

    @GetMapping("/excluirAluno/{id}")
    public String excluirAluno(@PathVariable("id") Long id, Model model) {
        alunoRepository.deleteById(String.valueOf(id));
        listarAluno(model);
        return "aluno/listarAluno";
    }
}


