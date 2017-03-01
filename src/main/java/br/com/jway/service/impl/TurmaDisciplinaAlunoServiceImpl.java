package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.TurmaDisciplinaAluno;
import br.com.jway.dao.TurmaDisciplinaAlunoDao;
import br.com.jway.service.TenancyService;
import br.com.jway.service.TurmaDisciplinaAlunoService;

@Named
public class TurmaDisciplinaAlunoServiceImpl implements TurmaDisciplinaAlunoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private TurmaDisciplinaAlunoDao dao;
	
	@Inject
	private TenancyService tenancyService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(TurmaDisciplinaAluno turmadisciplinaaluno){
		dao.create(turmadisciplinaaluno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(TurmaDisciplinaAluno turmadisciplinaaluno){
		dao.delete(turmadisciplinaaluno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(TurmaDisciplinaAluno turmadisciplinaaluno){
		dao.update(turmadisciplinaaluno);
	}
	@Override
	public TurmaDisciplinaAluno read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<TurmaDisciplinaAluno> list(){
		return dao.list();
 	}
	@Override
	public List<TurmaDisciplinaAluno> pesquisa(TurmaDisciplinaAluno turmadisciplinaaluno){
		return dao.pesquisa(turmadisciplinaaluno);
 	}
}