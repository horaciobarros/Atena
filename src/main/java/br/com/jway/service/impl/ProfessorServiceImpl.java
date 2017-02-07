package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Professor;
import br.com.jway.dao.ProfessorDao;
import br.com.jway.service.ProfessorService;

@Named
public class ProfessorServiceImpl implements ProfessorService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private ProfessorDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Professor professor){
		dao.create(professor);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Professor professor){
		dao.delete(professor);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Professor professor){
		dao.update(professor);
	}
	@Override
	public Professor read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Professor> list(){
		return dao.list();
 	}
	@Override
	public List<Professor> pesquisa(Professor professor){
		return dao.pesquisa(professor);
 	}
}