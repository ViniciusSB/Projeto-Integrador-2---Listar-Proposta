package com.unitins.projetointegrador2.service;

import java.util.List;

import com.unitins.projetointegrador2.model.Proposta;

public interface PropostaService {

	void salvar(Proposta proposta);

	void editar(Proposta proposta);

	void excluir(Integer id);

	Proposta buscarPorId(Integer id);

	List<Proposta> buscarTodos();

	List<Proposta> buscarPorTitulo(String nome);

	List<Proposta> buscarPorProfessor(String nome);

	List<Proposta> buscarPorAluno(String descricao, String aluno);
	
	List<Proposta> buscaGeral(String descricao, String aluno, String professor, String turma);

}
