package com.unitins.projetointegrador2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitins.projetointegrador2.model.SEMESTRE;
import com.unitins.projetointegrador2.model.Turma;
import com.unitins.projetointegrador2.service.TurmaService;

@Controller
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Turma turma) {
        return "/turma/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("turmas", service.buscarTodos());
        return "/turma/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Turma turma, RedirectAttributes attr) {
        service.salvar(turma);
        attr.addFlashAttribute("success", "Turma inserido com sucesso.");
        return "redirect:/turma/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("turma", service.buscarPorId(id));
        return "/turma/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Turma turma, RedirectAttributes attr) {
        service.editar(turma);
        attr.addFlashAttribute("success", "Turma editada com sucesso.");
        return "redirect:/turma/cadastrar";
    }
    
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
    	 if (service.turmaTemAluno(id)) {
             attr.addFlashAttribute("fail", "Turma não removida. Possui aluno(s) vinculado(s).");
         }else {
        	 service.excluir(id);
             attr.addFlashAttribute("success", "Turma excluida com sucesso.");
         }
        return "redirect:/turma/listar";
    }

    @ModelAttribute("semestres")
    public SEMESTRE[] getTipos(){
        return SEMESTRE.values();
    }

}
