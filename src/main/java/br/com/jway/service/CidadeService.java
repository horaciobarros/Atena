package br.com.jway.service;

import java.io.Serializable;
import java.util.List;

import br.com.jway.model.Cidade;

public interface CidadeService extends Serializable{
	

	public void create(Cidade cidade);

	public void delete(Cidade cidade);

	public void update(Cidade cidade);

	public List<Cidade> list();

	public void delete(long id);

	public Cidade read(String codigo);

	public List<Cidade> pesquisa(Cidade cidade);

}
