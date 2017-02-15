package br.com.jway.service;

import java.io.Serializable;
import java.util.List;

import br.com.jway.model.ServicoMatricula;

public interface ServicoMatriculaService extends Serializable{
	

	public void create(ServicoMatricula servicoMatricula);

	public void delete(ServicoMatricula servicoMatricula);

	public void update(ServicoMatricula servicoMatricula);

	public List<ServicoMatricula> list();

	public void delete(long id);

	public ServicoMatricula read(long id);

	public List<ServicoMatricula> pesquisa(ServicoMatricula servicoMatricula);

}
