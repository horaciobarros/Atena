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
		dao.create(lancamentoCobranca);
		
	}

	@Override
	public void delete(LancamentoCobranca lancamentoCobranca) {
		dao.delete(lancamentoCobranca);
		
	}

	@Override
	public void update(LancamentoCobranca lancamentoCobranca) {
		dao.update(lancamentoCobranca);
		
	}

	@Override
	public List<LancamentoCobranca> list() {
		return dao.list();
	}

	@Override
	public void delete(long id) {
		dao.delete(id);
		
	}

	@Override
	public LancamentoCobranca read(long id) {
		return dao.read(id);
	}

	@Override
	public List<LancamentoCobranca> pesquisa(LancamentoCobranca lancamentoCobranca) {
		return dao.pesquisa(lancamentoCobranca);
	}

}
