package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Disciplina;

public interface DisciplinaDao  {

	List<Disciplina> list();

	Disciplina read(long id);

	void create(Disciplina disciplina);

	Disciplina update(Disciplina disciplina);

	void delete(Disciplina disciplina);

	void delete(long id);

	public List<Disciplina> pesquisa(Disciplina disciplina);

}