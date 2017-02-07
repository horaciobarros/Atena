package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Turno;
import br.com.jway.dao.TurnoDao;
import br.com.jway.service.TurnoService;

@Named
public class TurnoServiceImpl implements TurnoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private TurnoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Turno turno){
		dao.create(turno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Turno turno){
		dao.delete(turno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Turno turno){
		dao.update(turno);
	}
	@Override
	public Turno read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Turno> list(){
		return dao.list();
 	}
	@Override
	public List<Turno> pesquisa(Turno turno){
		return dao.pesquisa(turno);
 	}
}