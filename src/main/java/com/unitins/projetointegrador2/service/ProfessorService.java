package com.unitins.projetointegrador2.service;

import java.util.List;

import com.unitins.projetointegrador2.model.Professor;

public interface ProfessorService {
    void salvar(Professor professor);

    void editar(Professor professor);

    void excluir(Integer id);

    Professor buscarPorId(Integer id);

    List<Professor> buscarTodos();

	boolean professorTemProposta(Integer id);
}
