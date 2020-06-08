package com.unitins.projetointegrador2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Proposta;
import com.unitins.projetointegrador2.model.TIPO;
import com.unitins.projetointegrador2.repository.PropostaDao;

@Repository
@Transactional(readOnly = false)
public class PropostaServiceImpl implements PropostaService {

	@Autowired
	private PropostaDao dao;

	@Override
	public void salvar(Proposta proposta) {
		dao.save(proposta);
	}

	@Override
	public void editar(Proposta proposta) {
		dao.update(proposta);
	}

	@Override
	public void excluir(Integer id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Proposta buscarPorId(Integer id) {
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proposta> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Proposta> buscarPorTitulo(String nome) {
		return dao.finByNome(nome);
	}

	@Override
	public List<Proposta> buscarPorProfessor(String nome) {
		return dao.findByTeacher(nome);
	}

	@Override
	public List<Proposta> buscarPorAluno(String descricao, String aluno) {
		return dao.finByStudent(descricao, aluno);
	}

	@Override
	public List<Proposta> buscaGeral(String descricao, String aluno, String professor, String turma, String tipo) {
		return dao.findGeneral(descricao, aluno, professor, turma, tipo);
	}

}
