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
@Table(name="horario")
public class Horario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="turma")
	private Turma turma;

	@Column(name="dia_semana")
	private String diaSemana;
	
	@ManyToOne
	@JoinColumn(name="disciplina_primeiro_horario")
	private Disciplina disciplinaPrimeiroHorario;
	
	@ManyToOne
	@JoinColumn(name="disciplina_segundo_horario")
	private Disciplina disciplinaSegundoHorario;
	
	
	@ManyToOne
	@JoinColumn(name="disciplina_terceiro_horario")
	private Disciplina disciplinaTerceiroHorario;
	
	
	@ManyToOne
	@JoinColumn(name="disciplina_quarto_horario")
	private Disciplina disciplinaQuartoHorario;
	
	
	@Column(name="codigo")
	private String codigo;

	@Column(name="fim")
	private String fim;

	@Column(name="inicio")
	private String inicio;

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

	public String getFim() { 
		return fim;
	}
	public void  setFim(String fim) { 
		this.fim = fim;
	}

	public String getInicio() { 
		return inicio;
	}
	public void  setInicio(String inicio) { 
		this.inicio = inicio;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public String getDiaSemana() {
		return diaSemana;
	}
	public void setDiaSemana(String diaSemana) {
		this.diaSemana = diaSemana;
	}
	public Disciplina getDisciplinaPrimeiroHorario() {
		return disciplinaPrimeiroHorario;
	}
	public void setDisciplinaPrimeiroHorario(Disciplina disciplinaPrimeiroHorario) {
		this.disciplinaPrimeiroHorario = disciplinaPrimeiroHorario;
	}
	public Disciplina getDisciplinaSegundoHorario() {
		return disciplinaSegundoHorario;
	}
	public void setDisciplinaSegundoHorario(Disciplina disciplinaSegundoHorario) {
		this.disciplinaSegundoHorario = disciplinaSegundoHorario;
	}
	public Disciplina getDisciplinaTerceiroHorario() {
		return disciplinaTerceiroHorario;
	}
	public void setDisciplinaTerceiroHorario(Disciplina disciplinaTerceiroHorario) {
		this.disciplinaTerceiroHorario = disciplinaTerceiroHorario;
	}
	public Disciplina getDisciplinaQuartoHorario() {
		return disciplinaQuartoHorario;
	}
	public void setDisciplinaQuartoHorario(Disciplina disciplinaQuartoHorario) {
		this.disciplinaQuartoHorario = disciplinaQuartoHorario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((diaSemana == null) ? 0 : diaSemana.hashCode());
		result = prime * result + ((disciplinaPrimeiroHorario == null) ? 0 : disciplinaPrimeiroHorario.hashCode());
		result = prime * result + ((disciplinaQuartoHorario == null) ? 0 : disciplinaQuartoHorario.hashCode());
		result = prime * result + ((disciplinaSegundoHorario == null) ? 0 : disciplinaSegundoHorario.hashCode());
		result = prime * result + ((disciplinaTerceiroHorario == null) ? 0 : disciplinaTerceiroHorario.hashCode());
		result = prime * result + ((fim == null) ? 0 : fim.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inicio == null) ? 0 : inicio.hashCode());
		result = prime * result + ((tenancy == null) ? 0 : tenancy.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		Horario other = (Horario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (diaSemana == null) {
			if (other.diaSemana != null)
				return false;
		} else if (!diaSemana.equals(other.diaSemana))
			return false;
		if (disciplinaPrimeiroHorario == null) {
			if (other.disciplinaPrimeiroHorario != null)
				return false;
		} else if (!disciplinaPrimeiroHorario.equals(other.disciplinaPrimeiroHorario))
			return false;
		if (disciplinaQuartoHorario == null) {
			if (other.disciplinaQuartoHorario != null)
				return false;
		} else if (!disciplinaQuartoHorario.equals(other.disciplinaQuartoHorario))
			return false;
		if (disciplinaSegundoHorario == null) {
			if (other.disciplinaSegundoHorario != null)
				return false;
		} else if (!disciplinaSegundoHorario.equals(other.disciplinaSegundoHorario))
			return false;
		if (disciplinaTerceiroHorario == null) {
			if (other.disciplinaTerceiroHorario != null)
				return false;
		} else if (!disciplinaTerceiroHorario.equals(other.disciplinaTerceiroHorario))
			return false;
		if (fim == null) {
			if (other.fim != null)
				return false;
		} else if (!fim.equals(other.fim))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inicio == null) {
			if (other.inicio != null)
				return false;
		} else if (!inicio.equals(other.inicio))
			return false;
		if (tenancy == null) {
			if (other.tenancy != null)
				return false;
		} else if (!tenancy.equals(other.tenancy))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}
	
	
}