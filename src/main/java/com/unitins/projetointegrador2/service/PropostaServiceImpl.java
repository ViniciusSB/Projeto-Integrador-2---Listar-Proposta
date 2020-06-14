package com.unitins.projetointegrador2.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Proposta;
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
	public List<Proposta> buscaGeral(String descricao, String aluno, String professor, String turma, String tipo,
			LocalDate dataInicio, LocalDate dataFim) {
		
		if (dataInicio == null && dataFim == null){
			return dao.findGeneralWithoutDatas(descricao, aluno, professor, turma, tipo);
		} else if (dataInicio != null && dataFim != null) {
			return dao.findGeneral(descricao, aluno, professor, turma, tipo, dataInicio, dataFim);
		}else if (dataInicio != null){
			return dao.findGeneralWithoutDataFim(descricao, aluno, professor, turma, tipo, dataInicio);
		}else {
			return dao.findGeneralWithoutDataInicio(descricao, aluno, professor, turma, tipo, dataFim);
		}
	}

	@Override
	public List<Proposta> buscaSemTipo(String descricao, String aluno, String professor, String turma, 
			LocalDate dataInicio, LocalDate dataFim) {
		if (dataInicio == null && dataFim == null){
			return dao.findWithoutTipoAndDatas(descricao, aluno, professor, turma);
		} else if (dataInicio != null && dataFim != null) {
			return dao.findWithoutTipo(descricao, aluno, professor, turma, dataInicio, dataFim);
		}else if (dataInicio != null){
			return dao.findWithoutTipoAndDataFim(descricao, aluno, professor, turma, dataInicio);
		}else {
			return dao.findWithoutTipoAndDataInicio(descricao, aluno, professor, turma, dataFim);
		}
		
	}


}
