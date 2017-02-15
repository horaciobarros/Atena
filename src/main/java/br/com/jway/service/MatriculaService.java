package br.com.jway.service;

import java.io.Serializable;
import java.util.List;

import br.com.jway.model.Matricula;


public interface MatriculaService  extends Serializable {

	public void create(Matricula matricula);

	public void delete(Matricula matricula);

	public void update(Matricula matricula);

	public List<Matricula> list();

	public void delete(long id);

	public Matricula read(long id);

	public List<Matricula> pesquisa(Matricula matricula);
}
