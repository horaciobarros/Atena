package br.com.jway.service;

import java.io.Serializable;
import java.util.List;

import br.com.jway.model.Servico;

public interface ServicoService extends Serializable{
	

	public void create(Servico servico);

	public void delete(Servico servico);

	public void update(Servico servico);

	public List<Servico> list();

	public void delete(long id);

	public Servico read(long id);

	public List<Servico> pesquisa(Servico servico);

}
