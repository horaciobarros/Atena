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
import br.com.jway.service.PessoaService;

@Named
public class AlunoServiceImpl implements AlunoService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private AlunoDao dao;
	
	@Inject 
	private PessoaService pessoaService;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void create(Aluno aluno){
		if (aluno.getPessoa().getId() == null) {
			aluno.getPessoa().setTenancy(Long.valueOf(1));
			aluno.setPessoa(pessoaService.create(aluno.getPessoa()));
		}
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
			aluno.setPessoa(pessoaService.update(aluno.getPessoa()));
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