package br.com.jway.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jway.dao.LancamentoCobrancaDao;
import br.com.jway.model.LancamentoCobranca;
import br.com.jway.service.LancamentoCobrancaService;

@Named
public class LancamentoCobrancaServiceImpl implements LancamentoCobrancaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private LancamentoCobrancaDao dao;

	@Override
	public void create(LancamentoCobranca lancamentoCobranca) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LancamentoCobranca lancamentoCobranca) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(LancamentoCobranca lancamentoCobranca) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LancamentoCobranca> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LancamentoCobranca read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LancamentoCobranca> pesquisa(LancamentoCobranca lancamentoCobranca) {
		// TODO Auto-generated method stub
		return null;
	}

}
