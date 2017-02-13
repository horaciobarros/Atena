package br.com.jway.dao;

import java.util.List;

import br.com.jway.model.Uf;


public interface UfDao {
	List<Uf> list();

	Uf read(long id);

	void create(Uf uf);

	Uf update(Uf uf);

	void delete(Uf uf);

	void delete(long id);

	public List<Uf> pesquisa(Uf uf);


}
