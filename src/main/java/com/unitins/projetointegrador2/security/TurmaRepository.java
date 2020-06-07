package com.unitins.projetointegrador2.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unitins.projetointegrador2.model.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer> {

}
