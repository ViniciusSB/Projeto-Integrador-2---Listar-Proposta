package com.unitins.projetointegrador2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.repository.AlunoDao;

@Service
@Transactional(readOnly = false)
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoDao dao;

    @Override
    public void salvar(Aluno aluno) {
        dao.save(aluno);
    }

    @Override
    public void editar(Aluno aluno) {
        dao.update(aluno);
    }

    @Override
    public void excluir(Integer id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Aluno buscarPorId(Integer id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Aluno> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean alunoTemProposta(Integer id) {
        if (buscarPorId(id).getPropostas().isEmpty()){
            return false;
        }
        return true;
    }
}
