package br.com.jway.service;

import java.io.Serializable;
import java.util.List;

import br.com.jway.model.Uf;

public interface UfService extends Serializable {
	public void create(Uf uf);

	public void delete(Uf uf);

	public void update(Uf uf);

	public List<Uf> list();

	public void delete(long id);

	public Uf read(long id);

	public List<Uf> pesquisa(Uf uf);

}
