package com.unitins.projetointegrador2.service;

import java.time.LocalDate;
import java.util.List;

import com.unitins.projetointegrador2.model.Proposta;

public interface PropostaService {

	void salvar(Proposta proposta);

	void editar(Proposta proposta);

	void excluir(Integer id);

	Proposta buscarPorId(Integer id);

	List<Proposta> buscarTodos();
	
	List<Proposta> buscaSemTipo(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio, LocalDate dataFim);
	
	List<Proposta> buscaGeral(String descricao, String aluno, String professor, String turma, String tipo,
			LocalDate dataInicio, LocalDate dataFim);

}
