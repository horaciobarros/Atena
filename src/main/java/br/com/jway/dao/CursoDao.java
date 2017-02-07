package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Curso;

public interface CursoDao  {

	List<Curso> list();

	Curso read(long id);

	void create(Curso curso);

	Curso update(Curso curso);

	void delete(Curso curso);

	void delete(long id);

	public List<Curso> pesquisa(Curso curso);

}