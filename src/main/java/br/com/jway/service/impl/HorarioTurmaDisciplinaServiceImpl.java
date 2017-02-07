package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.HorarioTurmaDisciplina;
import br.com.jway.dao.HorarioTurmaDisciplinaDao;
import br.com.jway.service.HorarioTurmaDisciplinaService;

@Named
public class HorarioTurmaDisciplinaServiceImpl implements HorarioTurmaDisciplinaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private HorarioTurmaDisciplinaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(HorarioTurmaDisciplina horarioturmadisciplina){
		dao.create(horarioturmadisciplina);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(HorarioTurmaDisciplina horarioturmadisciplina){
		dao.delete(horarioturmadisciplina);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(HorarioTurmaDisciplina horarioturmadisciplina){
		dao.update(horarioturmadisciplina);
	}
	@Override
	public HorarioTurmaDisciplina read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<HorarioTurmaDisciplina> list(){
		return dao.list();
 	}
	@Override
	public List<HorarioTurmaDisciplina> pesquisa(HorarioTurmaDisciplina horarioturmadisciplina){
		return dao.pesquisa(horarioturmadisciplina);
 	}
}