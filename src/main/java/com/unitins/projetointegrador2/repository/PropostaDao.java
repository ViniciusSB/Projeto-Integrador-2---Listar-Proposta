package com.unitins.projetointegrador2.repository;

import java.util.List;

import com.unitins.projetointegrador2.model.Proposta;

public interface PropostaDao {
	void save(Proposta proposta);

	void update(Proposta proposta);

	void delete(Integer id);

	Proposta findById(Integer id);

	List<Proposta> findAll();

	List<Proposta> finByNome(String nome);

	List<Proposta> finByStudent(String descricao, String aluno);

	List<Proposta> findByTeacher(String nome);
	
	List<Proposta> findGeneral(String descricao, String aluno, String professor, String turma);
}


