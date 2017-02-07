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
@Table(name="turma_disciplina")
public class TurmaDisciplina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "turma")
	private Turma turma;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}


	public  Disciplina  getDisciplina() { 
		return disciplina;
	}
	public void  setDisciplina(Disciplina disciplina) { 
		this.disciplina = disciplina;
	}


	public  Turma  getTurma() { 
		return turma;
	}
	public void  setTurma(Turma turma) { 
		this.turma = turma;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
}