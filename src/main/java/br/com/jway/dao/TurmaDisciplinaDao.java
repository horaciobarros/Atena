package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.TurmaDisciplina;

public interface TurmaDisciplinaDao  {

	List<TurmaDisciplina> list();

	TurmaDisciplina read(long id);

	void create(TurmaDisciplina turmadisciplina);

	TurmaDisciplina update(TurmaDisciplina turmadisciplina);

	void delete(TurmaDisciplina turmadisciplina);

	void delete(long id);

	public List<TurmaDisciplina> pesquisa(TurmaDisciplina turmadisciplina);

}