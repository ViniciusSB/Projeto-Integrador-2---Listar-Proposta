package com.unitins.projetointegrador2.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.model.Proposta;
import com.unitins.projetointegrador2.model.STATUS;
import com.unitins.projetointegrador2.model.TIPO;
import com.unitins.projetointegrador2.service.AlunoService;
import com.unitins.projetointegrador2.service.ProfessorService;
import com.unitins.projetointegrador2.service.PropostaService;

@Controller
@RequestMapping("/proposta")
public class PropostaController {

	@Autowired
	private PropostaService service;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private ProfessorService professorService;

	@GetMapping("/cadastrar")
	public String cadastrar(Proposta Proposta) {
		return "/proposta/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("propostas", service.buscarTodos());
		
		// carregando os tipos de proposta
		model.addAttribute(new Proposta());
		model.addAttribute("tipo", TIPO.values());
		
		return "/proposta/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Proposta proposta, RedirectAttributes attr) {
		service.salvar(proposta);
		attr.addFlashAttribute("success", "Proposta inserido com sucesso.");
		return "redirect:/proposta/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
		model.addAttribute("proposta", service.buscarPorId(id));
		return "/proposta/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Proposta proposta, RedirectAttributes attr) {
		service.editar(proposta);
		attr.addFlashAttribute("success", "Proposta editado com sucesso.");
		return "redirect:/proposta/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Integer id, RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("success", "Proposta removida com sucesso.");
		return "redirect:/proposta/listar";
	}

	@RequestMapping(value = "/pesquisar")	
	public ModelAndView pesquisar(Model model, @RequestParam("pesquisarDescricao") String pesquisarDescricao, 
			@RequestParam("pesquisarAluno") String pesquisarAluno, 
			@RequestParam("pesquisarProfessor") String pesquisarProfessor,
			@RequestParam("pesquisarTurma") String pesquisarTurma, 
			@RequestParam(value = "tipo", required = false) String pesquisarTipo,
			@RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam("dataFim")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {
		
		// carregando os tipos de proposta
		model.addAttribute("tipo", "adicionarTipo");
		model.addAttribute(new Proposta());
		model.addAttribute("tipo", TIPO.values());
		
		ModelAndView modelAndView = new ModelAndView("/proposta/lista");
		if (pesquisarTipo == null) {
			modelAndView.addObject("propostas", service.buscaSemTipo(pesquisarDescricao, pesquisarAluno, pesquisarProfessor,
					pesquisarTurma, dataInicio, dataFim));
		} else {
			modelAndView.addObject("propostas", service.buscaGeral(pesquisarDescricao, pesquisarAluno, pesquisarProfessor,
					pesquisarTurma, pesquisarTipo, dataInicio, dataFim));
		}
	
		return modelAndView;
	}

	@ModelAttribute("professores")
	public List<Professor> listaDeProfessores() {
		return professorService.buscarTodos();
	}

	@ModelAttribute("alunos")
	public List<Aluno> listaDeAlunos() {
		return alunoService.buscarTodos();
	}

	@ModelAttribute("tipos")
	public TIPO[] getTipos() {
		return TIPO.values();
	}

	@ModelAttribute("status")
	public STATUS[] getStatus() {
		return STATUS.values();
	}

}
