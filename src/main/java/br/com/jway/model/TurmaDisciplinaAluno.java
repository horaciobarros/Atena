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
@Table(name="turma_disciplina_aluno")
public class TurmaDisciplinaAluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aluno")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "turma_disciplina")
	private TurmaDisciplina turmaDisciplina;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}


	public  Aluno  getAluno() { 
		return aluno;
	}
	public void  setAluno(Aluno aluno) { 
		this.aluno = aluno;
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