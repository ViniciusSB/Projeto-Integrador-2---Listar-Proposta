package com.unitins.projetointegrador2.repository;

import java.util.List;

import com.unitins.projetointegrador2.model.Professor;

public interface ProfessorDao {

    void save(Professor professor);

    void update(Professor professor);

    void delete(Integer id);

    Professor findById(Integer id);

    List<Professor> findAll();

}
