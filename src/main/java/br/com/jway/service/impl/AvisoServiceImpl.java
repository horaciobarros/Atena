package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Aviso;
import br.com.jway.dao.AvisoDao;
import br.com.jway.service.AvisoService;

@Named
public class AvisoServiceImpl implements AvisoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private AvisoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Aviso aviso){
		dao.create(aviso);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Aviso aviso){
		dao.delete(aviso);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Aviso aviso){
		dao.update(aviso);
	}
	@Override
	public Aviso read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Aviso> list(){
		return dao.list();
 	}
	@Override
	public List<Aviso> pesquisa(Aviso aviso){
		return dao.pesquisa(aviso);
 	}
}