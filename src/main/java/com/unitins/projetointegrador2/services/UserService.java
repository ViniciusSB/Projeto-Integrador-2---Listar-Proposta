package com.unitins.projetointegrador2.services;

import com.unitins.projetointegrador2.model.Pessoa;

import java.util.Optional;

public interface UserService {
    Optional<Pessoa> findUserByEmail(String email);

    Optional<Pessoa> findUserByResetToken(String resetToken);

    void saveUser(Pessoa user);
}