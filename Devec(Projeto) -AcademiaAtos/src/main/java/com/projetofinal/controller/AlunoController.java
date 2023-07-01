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
    public String exibirFormularioAlterar(@PathVariable("id") Long id, Model model) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(id);
        if (alunoOpt.isPresent()) {
            Aluno aluno = alunoOpt.get();
            model.addAttribute("aluno", aluno);
            return "aluno/alterarAluno";
        } else {
            return "/aluno/listarAluno";
        }
    }

    @PostMapping("/alterarAluno/{id}")
    public String alterarAluno(@PathVariable("id") Long id, @ModelAttribute Aluno aluno, Model model) {
        Optional<Aluno> alunoOpt = alunoRepository.findById(id);
        if (alunoOpt.isPresent()) {
            Aluno alunoExistente = alunoOpt.get();
            alunoExistente.setNome(aluno.getNome());
            alunoExistente.setMatricula(aluno.getMatricula());
            alunoExistente.setCPF(aluno.getCPF());
            alunoExistente.setId(aluno.getId());
            // Alterar outros atributos do aluno conforme necessário

            alunoRepository.save(alunoExistente);
        }
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
