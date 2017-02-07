package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Horario;
import br.com.jway.dao.HorarioDao;
import br.com.jway.service.HorarioService;

@Named
public class HorarioServiceImpl implements HorarioService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private HorarioDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Horario horario){
		dao.create(horario);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Horario horario){
		dao.delete(horario);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Horario horario){
		dao.update(horario);
	}
	@Override
	public Horario read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Horario> list(){
		return dao.list();
 	}
	@Override
	public List<Horario> pesquisa(Horario horario){
		return dao.pesquisa(horario);
 	}
}