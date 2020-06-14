package com.unitins.projetointegrador2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.unitins.projetointegrador2.model.Proposta;

@Repository
public class PropostaDaoImpl extends AbstractDao<Proposta, Integer> implements PropostaDao {
	
	@Override
	public List<Proposta> findGeneral(String descricao, String aluno, String professor, String turma, String tipo,
			LocalDate dataInicio, LocalDate dataFim) {
		
		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and ")
		.append("p.tipo = upper(?5) and ")
		.append("p.dataInicio >= ?6 and ")
		.append("p.dataFim <= ?7 order by id")
		.toString();
				
		return createQuery(jpql, descricao, aluno, professor, turma, tipo, dataInicio, dataFim);
	}
	
	@Override
	public List<Proposta> findGeneralWithoutDataFim(String descricao, String aluno, String professor, String turma,
			String tipo, LocalDate dataInicio) {

		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and ")
		.append("p.tipo = upper(?5) and ")
		.append("p.dataInicio >= ?6 order by id")
		.toString();
						
		return createQuery(jpql, descricao, aluno, professor, turma, tipo, dataInicio);
		
	}

	@Override
	public List<Proposta> findGeneralWithoutDataInicio(String descricao, String aluno, String professor, String turma,
			String tipo, LocalDate dataFim) {
		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and ")
		.append("p.tipo = upper(?5) and ")
		.append("p.dataFim <= ?6 order by id")
		.toString();
						
		return createQuery(jpql, descricao, aluno, professor, turma, tipo, dataFim);
	}
	
	@Override
	public List<Proposta> findGeneralWithoutDatas(String descricao, String aluno, String professor, String turma,
			String tipo) {
		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and ")
		.append("p.tipo = upper(?5) order by id")
		.toString();
						
		return createQuery(jpql, descricao, aluno, professor, turma, tipo);
	}
	
	@Override
	public List<Proposta> findWithoutTipo(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio, LocalDate dataFim) {
		
		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and ")
		.append("p.dataInicio >= ?5 and ")
		.append("p.dataFim <= ?6 order by id")
		.toString();

		return createQuery(jpql, descricao, aluno, professor, turma, dataInicio, dataFim);
	}

	@Override
	public List<Proposta> findWithoutTipoAndDataFim(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio) {
		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and ")
		.append("p.dataInicio >= ?5 order by id")
		.toString();

		return createQuery(jpql, descricao, aluno, professor, turma, dataInicio);
	}

	@Override
	public List<Proposta> findWithoutTipoAndDataInicio(String descricao, String aluno, String professor, String turma,
			LocalDate dataFim) {
		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and ")
		.append("p.dataFim <= ?5 order by id")
		.toString();

		return createQuery(jpql, descricao, aluno, professor, turma, dataFim);
	}

	@Override
	public List<Proposta> findWithoutTipoAndDatas(String descricao, String aluno, String professor, String turma) {
		String jpql = new StringBuilder("select p from Proposta p ")
		.append("Where upper(p.descricao) like concat('%',upper(?1), '%') and ")
		.append("upper(p.aluno.nome) like concat('%',upper(?2), '%') and ")
		.append("upper(p.professor.nome) like concat('%',upper(?3), '%') and ")
		.append("upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') order by id")
		.toString();

		return createQuery(jpql, descricao, aluno, professor, turma);
	}

}
