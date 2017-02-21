package br.com.jway.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.dao.ServicoDao;
import br.com.jway.model.Servico;
import br.com.jway.service.ServicoService;

@Named
public class ServicoServiceImpl implements ServicoService{

	/**
	 * 
	 */
	
	@Inject
	private ServicoDao dao;
	
	private static final long serialVersionUID = 1L;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Servico servico) {
		dao.create(servico);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Servico servico) {
		dao.delete(servico);
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Servico servico) {
		dao.update(servico);
		
	}

	@Override
	public List<Servico> list() {
		
		return dao.list();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Servico read(long id) {
		
		return dao.read(id);
	}

	@Override
	public List<Servico> pesquisa(Servico servico) {
		// TODO Auto-generated method stub
		return null;
	}

}
