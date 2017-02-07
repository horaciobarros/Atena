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
@Table(name="aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="matricula")
	private String matricula;

	@Column(name="ra")
	private String ra;

	@Column(name="situacao")
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public String getMatricula() { 
		return matricula;
	}
	public void  setMatricula(String matricula) { 
		this.matricula = matricula;
	}

	public String getRa() { 
		return ra;
	}
	public void  setRa(String ra) { 
		this.ra = ra;
	}

	public String getSituacao() { 
		return situacao;
	}
	public void  setSituacao(String situacao) { 
		this.situacao = situacao;
	}


	public  Pessoa  getPessoa() { 
		return pessoa;
	}
	public void  setPessoa(Pessoa pessoa) { 
		this.pessoa = pessoa;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
}