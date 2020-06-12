package com.unitins.projetointegrador2.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.unitins.projetointegrador2.model.Proposta;
import com.unitins.projetointegrador2.model.TIPO;

@Repository
public class PropostaDaoImpl extends AbstractDao<Proposta, Integer> implements PropostaDao {

	@Override
	public List<Proposta> findByTeacher(String nome) {
		return createQuery("select p from Proposta p where upper(p.professor.nome) like concat('%',upper(?1), '%') ",
				nome);
	}

	@Override
	public List<Proposta> finByStudent(String descricao, String aluno) {
		return createQuery("select p from Proposta p where upper(p.descricao) like concat('%',upper(?1), '%')"
				+ " and upper(p.aluno.nome) like concat('%',upper(?2), '%') ", descricao, aluno);
	}

	@Override
	public List<Proposta> finByNome(String nome) {
		return createQuery("select p from Proposta p where upper(p.descricao) like concat('%',upper(?1), '%') ", nome);
	}

	@Override
	public List<Proposta> findGeneral(String descricao, String aluno, String professor, String turma, String tipo) {
		return createQuery("Select p From Proposta p Where upper(p.descricao) like concat('%',upper(?1), '%') and "
				+ "upper(p.aluno.nome) like concat('%',upper(?2), '%') and "
				+ "upper(p.professor.nome) like concat('%',upper(?3), '%') and "
				+ "upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%') and "
				+ "p.tipo = upper(?5)", descricao, aluno, professor, turma, tipo);
	}

	@Override
	public List<Proposta> findWithoutTipo(String descricao, String aluno, String professor, String turma) {
		return createQuery("Select p From Proposta p Where upper(p.descricao) like concat('%',upper(?1), '%') and "
				+ "upper(p.aluno.nome) like concat('%',upper(?2), '%') and "
				+ "upper(p.professor.nome) like concat('%',upper(?3), '%') and "
				+ "upper(p.aluno.turma.descricao) like concat('%',upper(?4), '%')", descricao, aluno, professor, turma);
	}

}
