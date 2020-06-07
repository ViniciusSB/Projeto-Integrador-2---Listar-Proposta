package com.unitins.projetointegrador2.services;

import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final PessoaRepository userRepository;

    public UserServiceImpl(PessoaRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional findUserByResetToken(String resetToken) {
        return userRepository.findByResetToken(resetToken);
    }

    @Override
    public void saveUser(Pessoa user) {
        userRepository.save(user);
    }
}