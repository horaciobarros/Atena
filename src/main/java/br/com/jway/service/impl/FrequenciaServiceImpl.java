package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Frequencia;
import br.com.jway.dao.FrequenciaDao;
import br.com.jway.service.FrequenciaService;

@Named
public class FrequenciaServiceImpl implements FrequenciaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private FrequenciaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Frequencia frequencia){
		dao.create(frequencia);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Frequencia frequencia){
		dao.delete(frequencia);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(Frequencia frequencia){
		dao.update(frequencia);
	}
	@Override
	public Frequencia read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Frequencia> list(){
		return dao.list();
 	}
	@Override
	public List<Frequencia> pesquisa(Frequencia frequencia){
		return dao.pesquisa(frequencia);
 	}
}