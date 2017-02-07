package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.ResponsavelAluno;
import br.com.jway.dao.ResponsavelAlunoDao;
import br.com.jway.service.ResponsavelAlunoService;

@Named
public class ResponsavelAlunoServiceImpl implements ResponsavelAlunoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private ResponsavelAlunoDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(ResponsavelAluno responsavelaluno){
		dao.create(responsavelaluno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(ResponsavelAluno responsavelaluno){
		dao.delete(responsavelaluno);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(ResponsavelAluno responsavelaluno){
		dao.update(responsavelaluno);
	}
	@Override
	public ResponsavelAluno read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<ResponsavelAluno> list(){
		return dao.list();
 	}
	@Override
	public List<ResponsavelAluno> pesquisa(ResponsavelAluno responsavelaluno){
		return dao.pesquisa(responsavelaluno);
 	}
}