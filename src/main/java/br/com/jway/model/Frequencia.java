package br.com.jway.model; 

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="frequencia")
public class Frequencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="data")
	private Date data;

	@Column(name="faltas")
	private Long faltas;

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

	public Date getData() { 
		return data;
	}
	public void  setData(Date data) { 
		this.data = data;
	}

	public Long getFaltas() { 
		return faltas;
	}
	public void  setFaltas(Long faltas) { 
		this.faltas = faltas;
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