package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Disciplina;
import br.com.jway.dao.DisciplinaDao;
import br.com.jway.service.DisciplinaService;

@Named
public class DisciplinaServiceImpl implements DisciplinaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private DisciplinaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Disciplina disciplina){
		dao.create(disciplina);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Disciplina disciplina){
		dao.delete(disciplina);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Disciplina disciplina){
		dao.update(disciplina);
	}
	@Override
	public Disciplina read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Disciplina> list(){
		return dao.list();
 	}
	@Override
	public List<Disciplina> pesquisa(Disciplina disciplina){
		return dao.pesquisa(disciplina);
 	}
}