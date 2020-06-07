package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, String> {

    Optional<Pessoa> findByCpf(String cpf);

    Optional<Pessoa> findByResetToken(String resetToken);

    Optional<Pessoa> findByEmail(String email);

}
