package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.TurmaDisciplina;
import br.com.jway.dao.TurmaDisciplinaDao;
import br.com.jway.service.TenancyService;
import br.com.jway.service.TurmaDisciplinaService;

@Named
public class TurmaDisciplinaServiceImpl implements TurmaDisciplinaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private TurmaDisciplinaDao dao;
	
	@Inject
	private TenancyService tenancyService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(TurmaDisciplina turmaDisciplina){
		turmaDisciplina.setTenancy(tenancyService.getTenancyDaSessao());
		dao.create(turmaDisciplina);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(TurmaDisciplina turmadisciplina){
		dao.delete(turmadisciplina);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(TurmaDisciplina turmadisciplina){
		dao.update(turmadisciplina);
	}
	@Override
	public TurmaDisciplina read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<TurmaDisciplina> list(){
		return dao.list();
 	}
	@Override
	public List<TurmaDisciplina> pesquisa(TurmaDisciplina turmadisciplina){
		return dao.pesquisa(turmadisciplina);
 	}
}