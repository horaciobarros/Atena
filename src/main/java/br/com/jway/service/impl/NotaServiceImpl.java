package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Nota;
import br.com.jway.dao.NotaDao;
import br.com.jway.service.NotaService;

@Named
public class NotaServiceImpl implements NotaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private NotaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Nota nota){
		dao.create(nota);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Nota nota){
		dao.delete(nota);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Nota nota){
		dao.update(nota);
	}
	@Override
	public Nota read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Nota> list(){
		return dao.list();
 	}
	@Override
	public List<Nota> pesquisa(Nota nota){
		return dao.pesquisa(nota);
 	}
}