package com.unitins.projetointegrador2.repository;

import java.time.LocalDate;
import java.util.List;

import com.unitins.projetointegrador2.model.Proposta;

public interface PropostaDao {
	void save(Proposta proposta);

	void update(Proposta proposta);

	void delete(Integer id);

	Proposta findById(Integer id);

	List<Proposta> findAll();
	
	List<Proposta> findGeneral(String descricao, String aluno, String professor, String turma, String tipo, LocalDate dataInicio,
			LocalDate dataFim);
	
	List<Proposta> findGeneralWithoutDatas(String descricao, String aluno, String professor, String turma,
			String tipo);

	List<Proposta> findGeneralWithoutDataFim(String descricao, String aluno, String professor, String turma, String tipo,
			LocalDate dataInicio);
	
	List<Proposta> findGeneralWithoutDataInicio(String descricao, String aluno, String professor, String turma, String tipo, 
			LocalDate dataFim);
	
	List<Proposta> findWithoutTipo(String descricao, String aluno, String professor, String turma, LocalDate dataInicio,
			LocalDate dataFim);
	
	List<Proposta> findWithoutTipoAndDataFim(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio);

	List<Proposta> findWithoutTipoAndDataInicio(String descricao, String aluno, String professor, String turma,
			LocalDate dataFim);
	
	List<Proposta> findWithoutTipoAndDatas(String descricao, String aluno, String professor, String turma);
}


