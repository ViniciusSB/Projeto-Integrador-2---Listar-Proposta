package com.unitins.projetointegrador2.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.service.AlunoService;

@Component
public class StringToAlunoConversor implements Converter<String, Aluno> {

    @Autowired
    private AlunoService service;

    @Override
    public Aluno convert(String text) {
        if (text.isEmpty()){
            return null;
        }
        Integer id = Integer.valueOf(text);
        return service.buscarPorId(id);
    }
}
