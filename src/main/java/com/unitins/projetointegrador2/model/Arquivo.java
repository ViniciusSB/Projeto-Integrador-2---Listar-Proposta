package com.unitins.projetointegrador2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Arquivo extends AuditoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String caminho;

    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ArquivoPessoa",
            joinColumns = @JoinColumn(name = "idArquivo"),
            inverseJoinColumns = @JoinColumn(name = "idPessoa"))
    private List<Pessoa> pessoas;
}
