package br.com.jway.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.dao.MatriculaDao;
import br.com.jway.model.Matricula;
import br.com.jway.service.MatriculaService;


@Named
public class MatriculaServiceImpl implements MatriculaService{
	
	private static final long serialVersionUID = 1L;

	@Inject 
	private MatriculaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Matricula matricula){
		dao.create(matricula);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Matricula matricula){
		dao.delete(matricula);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Matricula matricula){
		dao.update(matricula);
	}
	@Override
	public Matricula read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Matricula> list(){
		return dao.list();
 	}
	@Override
	public List<Matricula> pesquisa(Matricula matricula){
		return dao.pesquisa(matricula);
 	}

}
