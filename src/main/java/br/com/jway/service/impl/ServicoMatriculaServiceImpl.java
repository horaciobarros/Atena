package br.com.jway.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.jway.dao.ServicoMatriculaDao;
import br.com.jway.model.ServicoMatricula;
import br.com.jway.service.ServicoMatriculaService;

@Named
public class ServicoMatriculaServiceImpl implements ServicoMatriculaService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServicoMatriculaDao dao;

	@Override
	public void create(ServicoMatricula servicoMatricula) {
		dao.create(servicoMatricula);
		
	}

	@Override
	public void delete(ServicoMatricula servicoMatricula) {
		dao.delete(servicoMatricula);
		
	}

	@Override
	public void update(ServicoMatricula servicoMatricula) {
		dao.update(servicoMatricula);
		
	}

	@Override
	public List<ServicoMatricula> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServicoMatricula read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServicoMatricula> pesquisa(ServicoMatricula servicoMatricula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ServicoMatricula> findByMatriculaId(Long id) {
		return dao.findByMatriculaId(id);
	}

}
