package com.unitins.projetointegrador2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.repository.ProfessorDao;

@Service
@Transactional(readOnly = false)
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorDao dao;

    @Override
    public void salvar(Professor professor) {
        dao.save(professor);
    }

    @Override
    public void editar(Professor professor) {
        dao.update(professor);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Professor buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> buscarTodos() {
        return dao.findAll();
    }

	@Override
	public boolean professorTemProposta(Integer id) {
		if (buscarPorId(id).getProposta().isEmpty()){
            return false;
        }
        return true;
	}
}
