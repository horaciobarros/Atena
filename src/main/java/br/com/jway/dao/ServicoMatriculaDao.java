package br.com.jway.dao;

import java.util.List;

import br.com.jway.model.ServicoMatricula;

public interface ServicoMatriculaDao {
	
	List<ServicoMatricula> list();

	ServicoMatricula read(long id);

	void create(ServicoMatricula servicoMatricula);

	ServicoMatricula update(ServicoMatricula servicoMatricula);

	void delete(ServicoMatricula servicoMatricula);

	void delete(long id);

	public List<ServicoMatricula> pesquisa(ServicoMatricula servicoMatricula);


}
