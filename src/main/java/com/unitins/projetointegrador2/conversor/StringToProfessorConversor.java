package com.unitins.projetointegrador2.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.service.ProfessorService;

@Component
public class StringToProfessorConversor implements Converter<String, Professor> {

    @Autowired
    private ProfessorService service;

    @Override
    public Professor convert(String text) {
        if(text.isEmpty()) {
            return null;
        }
        Integer id = Integer.valueOf(text);
        return service.buscarPorId(id);
    }
}
