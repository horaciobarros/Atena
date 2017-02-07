package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Advertencia;
import br.com.jway.dao.AdvertenciaDao;
import br.com.jway.service.AdvertenciaService;

@Named
public class AdvertenciaServiceImpl implements AdvertenciaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private AdvertenciaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Advertencia advertencia){
		dao.create(advertencia);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Advertencia advertencia){
		dao.delete(advertencia);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Advertencia advertencia){
		dao.update(advertencia);
	}
	@Override
	public Advertencia read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Advertencia> list(){
		return dao.list();
 	}
	@Override
	public List<Advertencia> pesquisa(Advertencia advertencia){
		return dao.pesquisa(advertencia);
 	}
}