package br.com.jway.dao;

import java.util.List;

import br.com.jway.model.Cidade;

public interface CidadeDao {
	List<Cidade> list();

	Cidade read(long id);

	void create(Cidade cidade);

	Cidade update(Cidade cidade);

	void delete(Cidade cidade);

	void delete(long cidade);

	public List<Cidade> pesquisa(Cidade cidade);

}
