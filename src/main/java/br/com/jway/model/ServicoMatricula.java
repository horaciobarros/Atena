package br.com.jway.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "servico_matricula")
public class ServicoMatricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "servico")
	private Servico servico;

	@ManyToOne
	@JoinColumn(name = "matricula")
	private Matricula matricula;

	@Column
	private Long tenancy;

	@Column(name = "perc_desconto")
	private Integer percDesconto;

	@Transient
	private BigDecimal valorLiquido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Long getTenancy() {
		return tenancy;
	}

	public void setTenancy(Long tenancy) {
		this.tenancy = tenancy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getPercDesconto() {
		return percDesconto;
	}

	public void setPercDesconto(Integer percDesconto) {
		this.percDesconto = percDesconto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((percDesconto == null) ? 0 : percDesconto.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		result = prime * result + ((tenancy == null) ? 0 : tenancy.hashCode());
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
		ServicoMatricula other = (ServicoMatricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (percDesconto == null) {
			if (other.percDesconto != null)
				return false;
		} else if (!percDesconto.equals(other.percDesconto))
			return false;
		if (servico == null) {
			if (other.servico != null)
				return false;
		} else if (!servico.equals(other.servico))
			return false;
		if (tenancy == null) {
			if (other.tenancy != null)
				return false;
		} else if (!tenancy.equals(other.tenancy))
			return false;
		return true;
	}

	public BigDecimal getValorLiquido() {
		valorLiquido = new BigDecimal(0);
		if (getPercDesconto() != null) {
			valorLiquido = 	servico.getValor().subtract(servico.getValor().multiply(BigDecimal.valueOf(getPercDesconto()).divide(new BigDecimal(100))));
		} else {
			valorLiquido = valorLiquido.add(servico.getValor());

		}
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquidoMatricula) {
		this.valorLiquido = valorLiquidoMatricula;
	}

}
