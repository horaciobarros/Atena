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
}