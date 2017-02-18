package br.com.jway.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="matricula")
public class Matricula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="ano_letivo")
	private Long anoLetivo;
	
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@Column(name="situacao")
	private String situacao;
	
	@Column(name="tem_desconto")
	private String temDesconto;
	
	@Column(name="perc_desconto")
	private BigDecimal percDesconto;
	
	@ManyToOne
	@JoinColumn(name="aluno")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="turma")
	private Turma turma;
	
	@Column
	private Long tenancy;
	
	@Transient
	private List<ServicoMatricula> servicoMatriculaList;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(Long anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getTemDesconto() {
		return temDesconto;
	}

	public void setTemDesconto(String temDesconto) {
		this.temDesconto = temDesconto;
	}

	public BigDecimal getPercDesconto() {
		return percDesconto;
	}

	public void setPercDesconto(BigDecimal percDesconto) {
		this.percDesconto = percDesconto;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public Long getTenancy() {
		return tenancy;
	}

	public void setTenancy(Long tenancy) {
		this.tenancy = tenancy;
	}

	public List<ServicoMatricula> getServicoMatriculaList() {
		return servicoMatriculaList;
	}

	public void setServicoMatriculaList(List<ServicoMatricula> servicoMatriculaList) {
		this.servicoMatriculaList = servicoMatriculaList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((anoLetivo == null) ? 0 : anoLetivo.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((percDesconto == null) ? 0 : percDesconto.hashCode());
		result = prime * result + ((servicoMatriculaList == null) ? 0 : servicoMatriculaList.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + ((temDesconto == null) ? 0 : temDesconto.hashCode());
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
		Matricula other = (Matricula) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (anoLetivo == null) {
			if (other.anoLetivo != null)
				return false;
		} else if (!anoLetivo.equals(other.anoLetivo))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (percDesconto == null) {
			if (other.percDesconto != null)
				return false;
		} else if (!percDesconto.equals(other.percDesconto))
			return false;
		if (servicoMatriculaList == null) {
			if (other.servicoMatriculaList != null)
				return false;
		} else if (!servicoMatriculaList.equals(other.servicoMatriculaList))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (temDesconto == null) {
			if (other.temDesconto != null)
				return false;
		} else if (!temDesconto.equals(other.temDesconto))
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
