package br.com.jway.model; 

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.sql.Time;

@Entity 
@Table(name="nota")
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="descricao")
	private String descricao;

	@Column(name="nota")
	private double nota;

	@Column(name="atividade")
	private Long atividade;

	@ManyToOne
	@JoinColumn(name = "turma_disciplina_aluno")
	private TurmaDisciplina turmaDisciplina;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public String getDescricao() { 
		return descricao;
	}
	public void  setDescricao(String descricao) { 
		this.descricao = descricao;
	}

	public double getNota() { 
		return nota;
	}
	public void  setNota(double nota) { 
		this.nota = nota;
	}

	public Long getAtividade() { 
		return atividade;
	}
	public void  setAtividade(Long atividade) { 
		this.atividade = atividade;
	}


	public  TurmaDisciplina  getTurmaDisciplina() { 
		return turmaDisciplina;
	}
	public void  setTurmaDisciplina(TurmaDisciplina turmaDisciplina) { 
		this.turmaDisciplina = turmaDisciplina;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
}