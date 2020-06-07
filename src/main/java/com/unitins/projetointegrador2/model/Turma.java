package com.unitins.projetointegrador2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "TURMA")
public class Turma extends AbstractEntity<Integer> {
	
	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Integer ano;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private SEMESTRE semestre;

	@OneToMany(mappedBy = "turma")
	private List<Aluno> aluno;

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public SEMESTRE getSemestre() {
		return semestre;
	}

	public void setSemestre(SEMESTRE semestre) {
		this.semestre = semestre;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
