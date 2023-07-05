package com.projetofinal.controller;

import com.projetofinal.model.Disciplina;
import com.projetofinal.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping("/adicionarDisciplina")
    public String adicionarDisciplina(Model model) {
        model.addAttribute("disciplina", new Disciplina());
        return "disciplina/adicionarDisciplina";
    }

    @PostMapping("/adicionarDisciplina")
    public String adicionarDisciplina(@ModelAttribute Disciplina disciplina, Model model) {
        disciplinaRepository.save(disciplina);
        return "redirect:/disciplina/listarDisciplina";
    }

    @GetMapping("/listar")
    public List<Disciplina> listarDisciplina() {
        return disciplinaRepository.findAll();
    }

    @PutMapping("/{id}")
    public Disciplina atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizado) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrado com o ID fornecido."));
        disciplina.setNome(disciplinaAtualizado.getNome());
        disciplina.setProfessor(disciplinaAtualizado.getProfessor());
        return disciplinaRepository.save(disciplina);
    }

    @DeleteMapping("/{id}")
    public void removerProfessor(@PathVariable Long id) {
        disciplinaRepository.deleteById(id);
    }
}