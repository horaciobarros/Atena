package br.com.jway.dao; 

import java.util.*;

import br.com.jway.model.Matricula;

public interface MatriculaDao  {

	List<Matricula> list();

	Matricula read(long id);

	void create(Matricula matricula);

	Matricula update(Matricula matricula);

	void delete(Matricula matricula);

	void delete(long id);

	public List<Matricula> pesquisa(Matricula matricula);

}