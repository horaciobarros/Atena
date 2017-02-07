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
@Table(name="responsavel_aluno")
public class ResponsavelAluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="responsavel_financeiro")
	private int responsavelFinanceiro;

	@ManyToOne
	@JoinColumn(name = "aluno")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "responsavel")
	private Responsavel responsavel;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public int getResponsavelFinanceiro() { 
		return responsavelFinanceiro;
	}
	public void  setResponsavelFinanceiro(int responsavelFinanceiro) { 
		this.responsavelFinanceiro = responsavelFinanceiro;
	}


	public  Aluno  getAluno() { 
		return aluno;
	}
	public void  setAluno(Aluno aluno) { 
		this.aluno = aluno;
	}


	public  Responsavel  getResponsavel() { 
		return responsavel;
	}
	public void  setResponsavel(Responsavel responsavel) { 
		this.responsavel = responsavel;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
}