package br.com.jway.dao;

import java.util.List;

import br.com.jway.model.Servico;

public interface ServicoDao {
	List<Servico> list();

	Servico read(long id);

	void create(Servico servico);

	Servico update(Servico servico);

	void delete(Servico servico);

	void delete(long id);

	public List<Servico> pesquisa(Servico servico);

}
