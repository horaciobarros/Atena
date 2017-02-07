package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Escola;
import br.com.jway.dao.EscolaDao;
import br.com.jway.service.EscolaService;

@Named
public class EscolaServiceImpl implements EscolaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private EscolaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Escola escola){
		dao.create(escola);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Escola escola){
		dao.delete(escola);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Escola escola){
		dao.update(escola);
	}
	@Override
	public Escola read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Escola> list(){
		return dao.list();
 	}
	@Override
	public List<Escola> pesquisa(Escola escola){
		return dao.pesquisa(escola);
 	}
}