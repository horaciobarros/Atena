package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Turma;
import br.com.jway.dao.TurmaDao;
import br.com.jway.service.TurmaService;

@Named
public class TurmaServiceImpl implements TurmaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private TurmaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Turma turma){
		dao.create(turma);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Turma turma){
		dao.delete(turma);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Turma turma){
		dao.update(turma);
	}
	@Override
	public Turma read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Turma> list(){
		return dao.list();
 	}
	@Override
	public List<Turma> pesquisa(Turma turma){
		return dao.pesquisa(turma);
 	}
}