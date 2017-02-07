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
@Table(name="horario_turma_disciplina")
public class HorarioTurmaDisciplina implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="horario")
	private Long horario;

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

	public Long getHorario() { 
		return horario;
	}
	public void  setHorario(Long horario) { 
		this.horario = horario;
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