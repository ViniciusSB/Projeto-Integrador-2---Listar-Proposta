package com.unitins.projetointegrador2.model;

public enum TIPO {
    TCC("TCC"),
    PCC("PCC");

    private final String descricao;


    private TIPO(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
