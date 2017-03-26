package br.com.jway.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name="baixa_cobranca")
public class BaixaCobranca implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="lancamentoCobranca")
	private LancamentoCobranca lancamentoCobranca;
	
	@Column(name="data_pagamento" )
	private Date dataPagamento;
	
	@Column(name = "juros")
	private BigDecimal juros;
	
	@Column(name="multa")
	private BigDecimal multa;
	
	@Column(name="valor_pago")
	private BigDecimal valorPago;
	
	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LancamentoCobranca getLancamentoCobranca() {
		return lancamentoCobranca;
	}

	public void setLancamentoCobranca(LancamentoCobranca lancamentoCobranca) {
		this.lancamentoCobranca = lancamentoCobranca;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public BigDecimal getMulta() {
		return multa;
	}

	public void setMulta(BigDecimal multa) {
		this.multa = multa;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((juros == null) ? 0 : juros.hashCode());
		result = prime * result + ((lancamentoCobranca == null) ? 0 : lancamentoCobranca.hashCode());
		result = prime * result + ((multa == null) ? 0 : multa.hashCode());
		result = prime * result + ((tenancy == null) ? 0 : tenancy.hashCode());
		result = prime * result + ((valorPago == null) ? 0 : valorPago.hashCode());
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
		BaixaCobranca other = (BaixaCobranca) obj;
		if (dataPagamento == null) {
			if (other.dataPagamento != null)
				return false;
		} else if (!dataPagamento.equals(other.dataPagamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (juros == null) {
			if (other.juros != null)
				return false;
		} else if (!juros.equals(other.juros))
			return false;
		if (lancamentoCobranca == null) {
			if (other.lancamentoCobranca != null)
				return false;
		} else if (!lancamentoCobranca.equals(other.lancamentoCobranca))
			return false;
		if (multa == null) {
			if (other.multa != null)
				return false;
		} else if (!multa.equals(other.multa))
			return false;
		if (tenancy == null) {
			if (other.tenancy != null)
				return false;
		} else if (!tenancy.equals(other.tenancy))
			return false;
		if (valorPago == null) {
			if (other.valorPago != null)
				return false;
		} else if (!valorPago.equals(other.valorPago))
			return false;
		return true;
	}

	
}
