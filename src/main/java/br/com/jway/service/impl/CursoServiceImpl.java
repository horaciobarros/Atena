package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Curso;
import br.com.jway.dao.CursoDao;
import br.com.jway.service.CursoService;

@Named
public class CursoServiceImpl implements CursoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private CursoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Curso curso){
		dao.create(curso);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Curso curso){
		dao.delete(curso);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Curso curso){
		dao.update(curso);
	}
	@Override
	public Curso read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Curso> list(){
		return dao.list();
 	}
	@Override
	public List<Curso> pesquisa(Curso curso){
		return dao.pesquisa(curso);
 	}
}