package com.projetofinal.controller;

import com.projetofinal.model.*;
import com.projetofinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/nota")
public class NotaController {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/adicionarNota")
    public String adicionarNota(Model model) {
       List<Aluno> listaAlunos = alunoRepository.findAll();
        List<Disciplina> listaDisciplinas = disciplinaRepository.findAll();
        model.addAttribute("nota", new Nota());
        model.addAttribute("listaDisciplinas", listaDisciplinas);
        model.addAttribute("listaAlunos", listaAlunos);
        return "nota/adicionarNota";
    }

    @PostMapping("/adicionarNota")
    public String adicionarNota(@ModelAttribute Nota nota, Model model) {
        notaRepository.save(nota);
        listarNota(model);
        return "nota/listarNota";
    }

    @GetMapping("/listarNota")
    public String listarNota( Model model) {
        List<Nota> listarNota = notaRepository.findAll();
        model.addAttribute("listarNota", listarNota);
        return "nota/listarNota";
    }

    @GetMapping("/alterarNota/{id}")
    public String alterarNota(@PathVariable Long id, Model model) {
        Nota nota = notaRepository.findById(id).get();
        model.addAttribute("nota", nota);
        List<Aluno> listaAlunos = alunoRepository.findAll();
        List<Disciplina> listaDisciplinas = disciplinaRepository.findAll();
        model.addAttribute("listaDisciplinas", listaDisciplinas);
        model.addAttribute("listaAlunos", listaAlunos);
        return "nota/alterarNota";
    }

    @PostMapping("/alterarNota/{id}")
    public String alterarNota(@ModelAttribute  Nota nota, Model model) {
        notaRepository.save(nota);
        listarNota(model);
        return "nota/listarNota";
    }

    @GetMapping("/excluirNota/{id}")
    public String excluirNota(@PathVariable("id") Long id, Model model) {
        notaRepository.deleteById(Long.valueOf(String.valueOf(id)));
        listarNota(model);
        return "nota/listarNota";
    }

    @PostMapping("/excluirNota/{id}")
    public String excluirNota(@ModelAttribute  Nota nota, Model model) {
        notaRepository.save(nota);
        listarNota(model);
        return "nota/listarNota";
    }
}