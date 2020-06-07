package com.unitins.projetointegrador2.model;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "PROPOSTA")
public class Proposta extends AbstractEntity<Integer> {
    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_aluno_fk")
    private Aluno aluno;

    @OneToOne
    @JoinColumn(name = "professor_id_fk")
    private Professor professor;


    @Column(nullable = false, length = 3)
    @Enumerated(EnumType.STRING)
    private TIPO tipo;

    @Column
    @Enumerated(EnumType.STRING)
    private STATUS status;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
