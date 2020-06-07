package com.unitins.projetointegrador2.service;

import java.util.List;

import com.unitins.projetointegrador2.model.Turma;

public interface TurmaService {

    void salvar(Turma turma);

    void editar(Turma turma);

    void excluir(Integer id);

    Turma buscarPorId(Integer id);

    List<Turma> buscarTodos();

	boolean turmaTemAluno(Integer id);

}
