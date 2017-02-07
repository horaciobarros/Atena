package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Nota;

public interface NotaDao  {

	List<Nota> list();

	Nota read(long id);

	void create(Nota nota);

	Nota update(Nota nota);

	void delete(Nota nota);

	void delete(long id);

	public List<Nota> pesquisa(Nota nota);

}