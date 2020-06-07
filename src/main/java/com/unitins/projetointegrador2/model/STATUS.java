package com.unitins.projetointegrador2.model;

public enum STATUS {
    ACEITO("Aceito"),
    RECUSADO("Recusado"),
    EM_ANALISE("Em análise");

    private String descricao;


    private STATUS(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
