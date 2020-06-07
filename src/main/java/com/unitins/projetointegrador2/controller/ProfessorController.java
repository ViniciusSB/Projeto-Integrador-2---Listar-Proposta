package com.unitins.projetointegrador2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.service.ProfessorService;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping("/cadastrar")
    public String cadastrar(Professor professor) {
        return "/professor/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("professores", professorService.buscarTodos());
        return "/professor/lista";
    }

    @PostMapping("/salvar")
    public String salvar(Professor professor, RedirectAttributes attr) {
        professorService.salvar(professor);
        attr.addFlashAttribute("success", "Professor inserido com sucesso.");
        return "redirect:/professor/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("professor", professorService.buscarPorId(id));
        return "/professor/cadastro";
    }

    @PostMapping("/editar")
    public String editar(Professor professor, RedirectAttributes attr) {
        professorService.editar(professor);
        attr.addFlashAttribute("success", "Professor editado com sucesso.");
        return "redirect:/professor/cadastrar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
    	  if (professorService.professorTemProposta(id)) {
              attr.addFlashAttribute("fail", "Professor não removido. Possui proposta(s) vinculada(s).");
          }else {
        	  professorService.excluir(id);
              attr.addFlashAttribute("success", "Professor excluido com sucesso.");
          }
        return "redirect:/professor/listar";
    }

}
