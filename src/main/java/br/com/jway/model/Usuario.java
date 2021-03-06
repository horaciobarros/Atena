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
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="login")
	private String login;

	@Column(name="nivel")
	private String nivel;

	@Column(name="password")
	private String password;

	@Column(name="tenancy")
	private Long tenancy;

	public Long getId() { 
		return id;
	}
	public void  setId(Long id) { 
		this.id = id;
	}

	public String getLogin() { 
		return login;
	}
	public void  setLogin(String login) { 
		this.login = login;
	}

	public String getNivel() { 
		return nivel;
	}
	public void  setNivel(String nivel) { 
		this.nivel = nivel;
	}

	public String getPassword() { 
		return password;
	}
	public void  setPassword(String password) { 
		this.password = password;
	}

	public Long getTenancy() { 
		return tenancy;
	}
	public void  setTenancy(Long tenancy) { 
		this.tenancy = tenancy;
	}
}