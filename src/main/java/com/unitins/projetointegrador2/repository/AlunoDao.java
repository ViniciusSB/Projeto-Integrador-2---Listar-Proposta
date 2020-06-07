package com.unitins.projetointegrador2.repository;

import java.util.List;

import com.unitins.projetointegrador2.model.Aluno;

public interface AlunoDao {
    void save(Aluno aluno);

    void update(Aluno aluno);

    void delete(Integer id);

    Aluno findById(Integer id);

    List<Aluno> findAll();
}
