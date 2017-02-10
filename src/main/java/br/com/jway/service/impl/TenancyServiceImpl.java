package br.com.jway.service.impl;

import java.io.Serializable;

import javax.inject.Named;

import br.com.jway.service.TenancyService;

@Named
public class TenancyServiceImpl implements TenancyService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Long getTenancyDaSessao() {
		// TODO implementar da maneira correta, utilizando entidade Tenancy e relacionamento com Usuário
		return Long.valueOf(1);
	}

}
