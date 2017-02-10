package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Professor;
import br.com.jway.dao.ProfessorDao;
import br.com.jway.service.PessoaService;
import br.com.jway.service.ProfessorService;
import br.com.jway.service.TenancyService;

@Named
public class ProfessorServiceImpl implements ProfessorService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private ProfessorDao dao;
	
	@Inject 
	private PessoaService pessoaService;
	
	@Inject
	private TenancyService tenancyService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Professor professor){
		if (professor.getPessoa().getId() == null) {
			professor.setTenancy(tenancyService.getTenancyDaSessao());
			professor.getPessoa().setTenancy(tenancyService.getTenancyDaSessao());
			professor.setPessoa(pessoaService.create(professor.getPessoa()));
		}
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
		professor.setPessoa(pessoaService.update(professor.getPessoa()));
		
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