package com.unitins.projetointegrador2.service;

import java.util.List;

import com.unitins.projetointegrador2.model.Aluno;

public interface AlunoService {

    void salvar(Aluno aluno);

    void editar(Aluno aluno);

    void excluir(Integer id);

    Aluno buscarPorId(Integer id);

    List<Aluno> buscarTodos();

    boolean alunoTemProposta(Integer id);

}
