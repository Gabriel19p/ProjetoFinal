package com.projetofinal.controller;

import com.projetofinal.model.Disciplina;
import com.projetofinal.model.Professor;
import com.projetofinal.repository.DisciplinaRepository;
import com.projetofinal.repository.ProfessorRepository;
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

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/adicionarDisciplina")
    public String adicionarDisciplina(Model model) {
        List<Professor> listaProfessores = professorRepository.findAll();
        model.addAttribute("disciplina", new Disciplina());
        model.addAttribute("listaProfessores", listaProfessores);
        return "disciplina/adicionarDisciplina";
    }

    @PostMapping("/adicionarDisciplina")
    public String adicionarDisciplina(@ModelAttribute Disciplina disciplina, Model model) {
        disciplinaRepository.save(disciplina);
        listarDisciplina(model);
        return "disciplina/listarDisciplina";
    }

    @GetMapping("/listarDisciplina")
    public String listarDisciplina(Model model) {
        List<Disciplina> listarDisciplina = disciplinaRepository.findAll();
        model.addAttribute("listarDisciplina", listarDisciplina);
        return "disciplina/listarDisciplina";
    }

    @GetMapping("/alterarDisciplina/{id}")
    public String alterarDisciplina(@PathVariable Long id, Model model) {
        Disciplina disciplina = disciplinaRepository.findById(id).get();
        List<Professor> listaProfessores = professorRepository.findAll();
        model.addAttribute("disciplina", disciplina);
        model.addAttribute("listaProfessores", listaProfessores);
        return "disciplina/alterarDisciplina";
    }

    @PostMapping("/alterarDisciplina/{id}")
    public String alterarDisciplina(@ModelAttribute Disciplina disciplina,Model model) {
       disciplinaRepository.save(disciplina);
        listarDisciplina(model);
        return "disciplina/listarDisciplina";
    }

    @GetMapping("/excluirDisciplina/{id}")
    public String excluirDisciplina(@PathVariable("id") Long id, Model model) {
        disciplinaRepository.deleteById(Long.valueOf(String.valueOf(id)));
        listarDisciplina(model);
        return "disciplina/listarDisciplina";
    }

    @PostMapping("/excluirDisciplina/{id}")
    public String excluirDisciplina(@ModelAttribute Disciplina disciplina, Model model) {
        disciplinaRepository.save(disciplina);
        listarDisciplina(model);
        return "disciplina/listarDisciplina";
    }
}