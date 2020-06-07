package com.unitins.projetointegrador2.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.unitins.projetointegrador2.model.Turma;
import com.unitins.projetointegrador2.service.TurmaService;

@Component
public class StringToTurmaConversor implements Converter<String, Turma> {

    @Autowired
    private TurmaService service;

    @Override
    public Turma convert(String text) {
        if (text.isEmpty()){
            return null;
        }
        Integer id = Integer.valueOf(text);
        return service.buscarPorId(id);
    }
}
