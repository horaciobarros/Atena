package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Responsavel;
import br.com.jway.dao.ResponsavelDao;
import br.com.jway.service.ResponsavelService;

@Named
public class ResponsavelServiceImpl implements ResponsavelService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private ResponsavelDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Responsavel responsavel){
		dao.create(responsavel);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Responsavel responsavel){
		dao.delete(responsavel);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Responsavel responsavel){
		dao.update(responsavel);
	}
	@Override
	public Responsavel read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Responsavel> list(){
		return dao.list();
 	}
	@Override
	public List<Responsavel> pesquisa(Responsavel responsavel){
		return dao.pesquisa(responsavel);
 	}
}