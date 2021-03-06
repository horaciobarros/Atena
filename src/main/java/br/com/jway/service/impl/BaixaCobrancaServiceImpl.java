package br.com.jway.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.dao.BaixaCobrancaDao;
import br.com.jway.model.BaixaCobranca;
import br.com.jway.service.BaixaCobrancaService;

@Named
public class BaixaCobrancaServiceImpl implements BaixaCobrancaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private BaixaCobrancaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(BaixaCobranca bc) {
		dao.create(bc);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(BaixaCobranca bc) {
		dao.delete(bc);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(BaixaCobranca bc) {
		dao.update(bc);
		
	}

	@Override
	public List<BaixaCobranca> list() {
		
		return dao.list();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaixaCobranca read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaixaCobranca> pesquisa(BaixaCobranca bc) {
		// TODO Auto-generated method stub
		return null;
	}

}
