package com.unitins.projetointegrador2.repository;

import java.util.List;

import com.unitins.projetointegrador2.model.Turma;

public interface TurmaDao {

    void save(Turma turma);

    void update(Turma turma);

    void delete(Integer id);

    Turma findById(Integer id);

    List<Turma> findAll();

}
