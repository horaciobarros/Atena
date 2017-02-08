package br.com.jway.service.impl; 

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.jway.model.Pessoa;
import br.com.jway.dao.PessoaDao;
import br.com.jway.service.PessoaService;

@Named
public class PessoaServiceImpl implements PessoaService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject 
	private PessoaDao dao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Pessoa create(Pessoa pessoa){
		pessoa = dao.create(pessoa);
		return pessoa;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Pessoa pessoa){
		dao.delete(pessoa);
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Pessoa update(Pessoa pessoa){
		dao.update(pessoa);
		return pessoa;
	}
	@Override
	public Pessoa read(long id) {
		return dao.read(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		dao.delete(id);
	}

	@Override
	public List<Pessoa> list(){
		return dao.list();
 	}
	@Override
	public List<Pessoa> pesquisa(Pessoa pessoa){
		return dao.pesquisa(pessoa);
 	}
}