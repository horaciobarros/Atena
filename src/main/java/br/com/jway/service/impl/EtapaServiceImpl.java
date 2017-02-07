package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Etapa;
import br.com.jway.dao.EtapaDao;
import br.com.jway.service.EtapaService;

@Named
public class EtapaServiceImpl implements EtapaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private EtapaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Etapa etapa){
		dao.create(etapa);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Etapa etapa){
		dao.delete(etapa);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Etapa etapa){
		dao.update(etapa);
	}
	@Override
	public Etapa read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Etapa> list(){
		return dao.list();
 	}
	@Override
	public List<Etapa> pesquisa(Etapa etapa){
		return dao.pesquisa(etapa);
 	}
}