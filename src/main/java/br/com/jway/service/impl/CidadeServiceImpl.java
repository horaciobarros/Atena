package br.com.jway.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jway.dao.CidadeDao;
import br.com.jway.dao.UfDao;
import br.com.jway.model.Cidade;
import br.com.jway.service.CidadeService;

@Named
public class CidadeServiceImpl implements CidadeService{

	/**
	 * 
	 */
	
	@Inject
	private CidadeDao dao;
	
	private static final long serialVersionUID = 1L;
	

	@Override
	public void create(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cidade cidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cidade> list() {
		return dao.list();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cidade read(String codigo) {
		return dao.read(codigo);
	}

	@Override
	public List<Cidade> pesquisa(Cidade cidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
