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

@Entity 
@Table(name="aluno")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="matricula")
	private String matricula;

	@Column(name="ra")
	private String ra;

	@Column(name="situacao")
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "pessoa")
	private Pessoa pessoa;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public String getMatricula() { 
		return matricula;
	}
	public void  setMatricula(String matricula) { 
		this.matricula = matricula;
	}

	public String getRa() { 
		return ra;
	}
	public void  setRa(String ra) { 
		this.ra = ra;
	}

	public String getSituacao() { 
		return situacao;
	}
	public void  setSituacao(String situacao) { 
		this.situacao = situacao;
	}


	public  Pessoa  getPessoa() { 
		return pessoa;
	}
	public void  setPessoa(Pessoa pessoa) { 
		this.pessoa = pessoa;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((ra == null) ? 0 : ra.hashCode());
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
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
		Aluno other = (Aluno) obj;
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
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (ra == null) {
			if (other.ra != null)
				return false;
		} else if (!ra.equals(other.ra))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (tenancy == null) {
			if (other.tenancy != null)
				return false;
		} else if (!tenancy.equals(other.tenancy))
			return false;
		return true;
	}
	
	
}