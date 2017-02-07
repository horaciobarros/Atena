package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Aluno;
import br.com.jway.dao.AlunoDao;
import br.com.jway.service.AlunoService;

@Named
public class AlunoServiceImpl implements AlunoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private AlunoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Aluno aluno){
		dao.create(aluno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Aluno aluno){
		dao.delete(aluno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Aluno aluno){
		dao.update(aluno);
	}
	@Override
	public Aluno read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Aluno> list(){
		return dao.list();
 	}
	@Override
	public List<Aluno> pesquisa(Aluno aluno){
		return dao.pesquisa(aluno);
 	}
}