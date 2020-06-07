package com.unitins.projetointegrador2.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "ALUNO")
public class Aluno extends AbstractEntity<Integer> {
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	@OneToMany(mappedBy = "aluno")
	private List<Proposta> propostas;

	@OneToOne
	@JoinColumn(name = "eturma_id_fk")
	private Turma turma;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Proposta> getPropostas() {
		return propostas;
	}

	public void setPropostas(List<Proposta> propostas) {
		this.propostas = propostas;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
