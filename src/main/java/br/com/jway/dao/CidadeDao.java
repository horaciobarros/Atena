package br.com.jway.dao;

import java.util.List;

import br.com.jway.model.Cidade;
import br.com.jway.model.Uf;

public interface CidadeDao {
	List<Cidade> list();

	Cidade read(String codigo);

	void create(Cidade cidade);

	Cidade update(Cidade cidade);

	void delete(Cidade cidade);

	void delete(long cidade);

	public List<Cidade> pesquisa(Cidade cidade);

	List<Cidade> findByUf(Uf uf);

}
