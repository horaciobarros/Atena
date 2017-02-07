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
@Table(name="aviso")
public class Aviso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="descricao")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "turma_disciplina_aluno")
	private TurmaDisciplinaAluno turmaDisciplinaAluno;

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


	public  TurmaDisciplinaAluno  getTurmaDisciplinaAluno() { 
		return turmaDisciplinaAluno;
	}
	public void  setTurmaDisciplinaAluno(TurmaDisciplinaAluno turmaDisciplinaAluno) { 
		this.turmaDisciplinaAluno = turmaDisciplinaAluno;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
}