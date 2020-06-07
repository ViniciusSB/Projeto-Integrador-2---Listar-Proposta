package com.unitins.projetointegrador2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.model.Turma;
import com.unitins.projetointegrador2.service.AlunoService;
import com.unitins.projetointegrador2.service.TurmaService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;
    
    @Autowired
    private TurmaService turmaService;

    @RequestMapping("/cadastrar")
    public String cadastrar(Aluno aluno){
        return "/aluno/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("alunos", alunoService.buscarTodos());
        return "/aluno/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Aluno aluno, RedirectAttributes attr) {
        alunoService.salvar(aluno);
        attr.addFlashAttribute("success", "aluno inserido com sucesso.");
        return "redirect:/aluno/cadastrar";
    }


    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("aluno", alunoService.buscarPorId(id));
        return "/aluno/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Aluno aluno, RedirectAttributes attr) {
        alunoService.editar(aluno);
        attr.addFlashAttribute("success", "aluno editado com sucesso.");
        return "redirect:/aluno/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
        if (alunoService.alunoTemProposta(id)) {
            attr.addFlashAttribute("fail", "Aluno não removido. Possui proposta(s) vinculada(s).");
        }else {
            alunoService.excluir(id);
            attr.addFlashAttribute("success", "Aluno excluido com sucesso.");
        }
        return "redirect:/aluno/listar";
    }
    
    @ModelAttribute("turmas")
    public List<Turma> listaDeTurmas(){
        return turmaService.buscarTodos();
    }


}
