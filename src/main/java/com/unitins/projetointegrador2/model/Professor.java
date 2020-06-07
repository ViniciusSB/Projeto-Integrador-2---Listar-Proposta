package com.unitins.projetointegrador2.model;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "PROFESSOR")
public class Professor extends AbstractEntity<Integer> {
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @OneToMany(mappedBy = "professor")
    private List<Proposta> proposta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Proposta> getProposta() {
        return proposta;
    }

    public void setProposta(List<Proposta> proposta) {
        this.proposta = proposta;
    }

}
