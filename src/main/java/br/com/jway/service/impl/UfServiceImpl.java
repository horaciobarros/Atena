package br.com.jway.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.jway.dao.UfDao;
import br.com.jway.model.Uf;
import br.com.jway.service.UfService;

@Named
public class UfServiceImpl implements UfService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UfDao dao;

	@Override
	public void create(Uf uf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Uf uf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Uf uf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Uf> list() {
		return dao.list();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Uf read(String uf) {
		return dao.read(uf);
	}

	@Override
	public List<Uf> pesquisa(Uf uf) {
		// TODO Auto-generated method stub
		return null;
	}

	
}