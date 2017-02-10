package br.com.jway.model; 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.sql.Time;

@Entity 
@Table(name="pessoa")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="data_nascimento")
	private Date dataNascimento;

	@Column(name="ativo")
	private int ativo;

	@Column(name="bairro")
	private String bairro;

	@Column(name="celular")
	private String celular;

	@Column(name="cep")
	private String cep;

	@Column(name="cidade")
	private String cidade;

	@Column(name="complemento")
	private String complemento;

	@Column(name="cpf")
	private String cpf;

	@Column(name="email")
	private String email;

	@Column(name="endereco")
	private String endereco;

	@Column(name="nome")
	private String nome;

	@Column(name="nome_mae")
	private String nomeMae;

	@Column(name="nome_pai")
	private String nomePai;

	@Column(name="numero")
	private String numero;

	@Column(name="status")
	private String status;

	@Column(name="telefone_fixo")
	private String telefoneFixo;

	@Column(name="uf")
	private String uf;

	@Column(name="tenancy")
	private Long tenancy;
	
	@Lob
	@Column(name="foto", columnDefinition = "BLOB",length=100000)
	private byte[] foto;


	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public Date getDataNascimento() { 
		return dataNascimento;
	}
	public void  setDataNascimento(Date dataNascimento) { 
		this.dataNascimento = dataNascimento;
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

	public String getCep() { 
		return cep;
	}
	public void  setCep(String cep) { 
		this.cep = cep;
	}

	public String getCidade() { 
		return cidade;
	}
	public void  setCidade(String cidade) { 
		this.cidade = cidade;
	}

	public String getComplemento() { 
		return complemento;
	}
	public void  setComplemento(String complemento) { 
		this.complemento = complemento;
	}

	public String getCpf() { 
		return cpf;
	}
	public void  setCpf(String cpf) { 
		this.cpf = cpf;
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

	public String getNome() { 
		return nome;
	}
	public void  setNome(String nome) { 
		this.nome = nome;
	}

	public String getNomeMae() { 
		return nomeMae;
	}
	public void  setNomeMae(String nomeMae) { 
		this.nomeMae = nomeMae;
	}

	public String getNomePai() { 
		return nomePai;
	}
	public void  setNomePai(String nomePai) { 
		this.nomePai = nomePai;
	}

	public String getNumero() { 
		return numero;
	}
	public void  setNumero(String numero) { 
		this.numero = numero;
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

	public String getUf() { 
		return uf;
	}
	public void  setUf(String uf) { 
		this.uf = uf;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
}