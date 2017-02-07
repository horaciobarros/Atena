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
@Table(name="turma")
public class Turma implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="codigo")
	private String codigo;

	@Column(name="descricao")
	private String descricao;

	@Column(name="numero_maximo_alunos")
	private Long numeroMaximoAlunos;

	@Column(name="periodo_letivo")
	private Long periodoLetivo;

	@ManyToOne
	@JoinColumn(name = "curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "local")
	private Local local;

	@ManyToOne
	@JoinColumn(name = "turno")
	private Turno turno;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public String getCodigo() { 
		return codigo;
	}
	public void  setCodigo(String codigo) { 
		this.codigo = codigo;
	}

	public String getDescricao() { 
		return descricao;
	}
	public void  setDescricao(String descricao) { 
		this.descricao = descricao;
	}

	public Long getNumeroMaximoAlunos() { 
		return numeroMaximoAlunos;
	}
	public void  setNumeroMaximoAlunos(Long numeroMaximoAlunos) { 
		this.numeroMaximoAlunos = numeroMaximoAlunos;
	}

	public Long getPeriodoLetivo() { 
		return periodoLetivo;
	}
	public void  setPeriodoLetivo(Long periodoLetivo) { 
		this.periodoLetivo = periodoLetivo;
	}


	public  Curso  getCurso() { 
		return curso;
	}
	public void  setCurso(Curso curso) { 
		this.curso = curso;
	}


	public  Local  getLocal() { 
		return local;
	}
	public void  setLocal(Local local) { 
		this.local = local;
	}


	public  Turno  getTurno() { 
		return turno;
	}
	public void  setTurno(Turno turno) { 
		this.turno = turno;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
}