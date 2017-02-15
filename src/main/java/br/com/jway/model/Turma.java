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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((numeroMaximoAlunos == null) ? 0 : numeroMaximoAlunos.hashCode());
		result = prime * result + ((periodoLetivo == null) ? 0 : periodoLetivo.hashCode());
		result = prime * result + ((tenancy == null) ? 0 : tenancy.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (numeroMaximoAlunos == null) {
			if (other.numeroMaximoAlunos != null)
				return false;
		} else if (!numeroMaximoAlunos.equals(other.numeroMaximoAlunos))
			return false;
		if (periodoLetivo == null) {
			if (other.periodoLetivo != null)
				return false;
		} else if (!periodoLetivo.equals(other.periodoLetivo))
			return false;
		if (tenancy == null) {
			if (other.tenancy != null)
				return false;
		} else if (!tenancy.equals(other.tenancy))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		return true;
	}
	
	
}