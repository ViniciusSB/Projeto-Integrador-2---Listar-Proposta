package com.unitins.projetointegrador2.model;

public enum SEMESTRE {
    SEMESTRE1("1º Semestre"),
    SEMESTRE2("2º Semestre");

    private String descricao;

    private SEMESTRE(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
