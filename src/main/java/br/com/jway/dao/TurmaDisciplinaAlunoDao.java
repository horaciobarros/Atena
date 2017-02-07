package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.TurmaDisciplinaAluno;

public interface TurmaDisciplinaAlunoDao  {

	List<TurmaDisciplinaAluno> list();

	TurmaDisciplinaAluno read(long id);

	void create(TurmaDisciplinaAluno turmadisciplinaaluno);

	TurmaDisciplinaAluno update(TurmaDisciplinaAluno turmadisciplinaaluno);

	void delete(TurmaDisciplinaAluno turmadisciplinaaluno);

	void delete(long id);

	public List<TurmaDisciplinaAluno> pesquisa(TurmaDisciplinaAluno turmadisciplinaaluno);

}