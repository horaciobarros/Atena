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
@Table(name="escola")
public class Escola implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="ativo")
	private int ativo;

	@Column(name="bairro")
	private String bairro;

	@Column(name="celular")
	private String celular;

	@Column(name="celular1")
	private String celular1;

	@Column(name="cep")
	private String cep;

	@ManyToOne
	@JoinColumn(name="cidade")
	private Cidade cidade;

	@Column(name="cnpj")
	private String cnpj;

	@Column(name="complemento")
	private String complemento;

	@Column(name="email")
	private String email;

	@Column(name="endereco")
	private String endereco;

	@Column(name="inscricao_estadual")
	private String inscricaoEstadual;

	@Column(name="inscricao_municipal")
	private String inscricaoMunicipal;

	@Column(name="nome")
	private String nome;

	@Column(name="numero")
	private String numero;

	@Column(name="site")
	private String site;

	@Column(name="status")
	private String status;

	@Column(name="telefone_fixo")
	private String telefoneFixo;

	@Column(name="telefone_fixo1")
	private String telefoneFixo1;

	@ManyToOne
	@JoinColumn(name="uf")
	private Uf uf;

	@Column(name="tenancy")
	private Long tenancy;
	
	@Column(name="ciclo")
	private String ciclo;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public int getAtivo() { 
		return ativo;
	}
	public void  setAtivo(int ativo) { 
		this.ativo = ativo;
	}

	public String getBairro() { 
		return bairro;
	}
	public void  setBairro(String bairro) { 
		this.bairro = bairro;
	}

	public String getCelular() { 
		return celular;
	}
	public void  setCelular(String celular) { 
		this.celular = celular;
	}

	public String getCelular1() { 
		return celular1;
	}
	public void  setCelular1(String celular1) { 
		this.celular1 = celular1;
	}

	public String getCep() { 
		return cep;
	}
	public void  setCep(String cep) { 
		this.cep = cep;
	}

	public Cidade getCidade() { 
		return cidade;
	}
	public void  setCidade(Cidade cidade) { 
		this.cidade = cidade;
	}

	public String getCnpj() { 
		return cnpj;
	}
	public void  setCnpj(String cnpj) { 
		this.cnpj = cnpj;
	}

	public String getComplemento() { 
		return complemento;
	}
	public void  setComplemento(String complemento) { 
		this.complemento = complemento;
	}

	public String getEmail() { 
		return email;
	}
	public void  setEmail(String email) { 
		this.email = email;
	}

	public String getEndereco() { 
		return endereco;
	}
	public void  setEndereco(String endereco) { 
		this.endereco = endereco;
	}

	public String getInscricaoEstadual() { 
		return inscricaoEstadual;
	}
	public void  setInscricaoEstadual(String inscricaoEstadual) { 
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() { 
		return inscricaoMunicipal;
	}
	public void  setInscricaoMunicipal(String inscricaoMunicipal) { 
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getNome() { 
		return nome;
	}
	public void  setNome(String nome) { 
		this.nome = nome;
	}

	public String getNumero() { 
		return numero;
	}
	public void  setNumero(String numero) { 
		this.numero = numero;
	}

	public String getSite() { 
		return site;
	}
	public void  setSite(String site) { 
		this.site = site;
	}

	public String getStatus() { 
		return status;
	}
	public void  setStatus(String status) { 
		this.status = status;
	}

	public String getTelefoneFixo() { 
		return telefoneFixo;
	}
	public void  setTelefoneFixo(String telefoneFixo) { 
		this.telefoneFixo = telefoneFixo;
	}

	public String getTelefoneFixo1() { 
		return telefoneFixo1;
	}
	public void  setTelefoneFixo1(String telefoneFixo1) { 
		this.telefoneFixo1 = telefoneFixo1;
	}

	public Uf getUf() { 
		return uf;
	}
	public void  setUf(Uf uf) { 
		this.uf = uf;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ativo;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((celular1 == null) ? 0 : celular1.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((ciclo == null) ? 0 : ciclo.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((inscricaoEstadual == null) ? 0 : inscricaoEstadual.hashCode());
		result = prime * result + ((inscricaoMunicipal == null) ? 0 : inscricaoMunicipal.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((site == null) ? 0 : site.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telefoneFixo == null) ? 0 : telefoneFixo.hashCode());
		result = prime * result + ((telefoneFixo1 == null) ? 0 : telefoneFixo1.hashCode());
		result = prime * result + ((tenancy == null) ? 0 : tenancy.hashCode());
		result = prime * result + ((uf == null) ? 0 : uf.hashCode());
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
		Escola other = (Escola) obj;
		if (ativo != other.ativo)
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (celular == null) {
			if (other.celular != null)
				return false;
		} else if (!celular.equals(other.celular))
			return false;
		if (celular1 == null) {
			if (other.celular1 != null)
				return false;
		} else if (!celular1.equals(other.celular1))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (ciclo == null) {
			if (other.ciclo != null)
				return false;
		} else if (!ciclo.equals(other.ciclo))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscricaoEstadual == null) {
			if (other.inscricaoEstadual != null)
				return false;
		} else if (!inscricaoEstadual.equals(other.inscricaoEstadual))
			return false;
		if (inscricaoMunicipal == null) {
			if (other.inscricaoMunicipal != null)
				return false;
		} else if (!inscricaoMunicipal.equals(other.inscricaoMunicipal))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (site == null) {
			if (other.site != null)
				return false;
		} else if (!site.equals(other.site))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telefoneFixo == null) {
			if (other.telefoneFixo != null)
				return false;
		} else if (!telefoneFixo.equals(other.telefoneFixo))
			return false;
		if (telefoneFixo1 == null) {
			if (other.telefoneFixo1 != null)
				return false;
		} else if (!telefoneFixo1.equals(other.telefoneFixo1))
			return false;
		if (tenancy == null) {
			if (other.tenancy != null)
				return false;
		} else if (!tenancy.equals(other.tenancy))
			return false;
		if (uf == null) {
			if (other.uf != null)
				return false;
		} else if (!uf.equals(other.uf))
			return false;
		return true;
	}
	
	
}