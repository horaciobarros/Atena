package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Local;
import br.com.jway.dao.LocalDao;
import br.com.jway.service.LocalService;

@Named
public class LocalServiceImpl implements LocalService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private LocalDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Local local){
		dao.create(local);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Local local){
		dao.delete(local);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Local local){
		dao.update(local);
	}
	@Override
	public Local read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Local> list(){
		return dao.list();
 	}
	@Override
	public List<Local> pesquisa(Local local){
		return dao.pesquisa(local);
 	}
}