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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ativo;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((celular == null) ? 0 : celular.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomeMae == null) ? 0 : nomeMae.hashCode());
		result = prime * result + ((nomePai == null) ? 0 : nomePai.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((telefoneFixo == null) ? 0 : telefoneFixo.hashCode());
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
		Pessoa other = (Pessoa) obj;
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
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
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
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomeMae == null) {
			if (other.nomeMae != null)
				return false;
		} else if (!nomeMae.equals(other.nomeMae))
			return false;
		if (nomePai == null) {
			if (other.nomePai != null)
				return false;
		} else if (!nomePai.equals(other.nomePai))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
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