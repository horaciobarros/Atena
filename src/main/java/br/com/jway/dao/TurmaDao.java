package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Turma;

public interface TurmaDao  {

	List<Turma> list();

	Turma read(long id);

	void create(Turma turma);

	Turma update(Turma turma);

	void delete(Turma turma);

	void delete(long id);

	public List<Turma> pesquisa(Turma turma);

}