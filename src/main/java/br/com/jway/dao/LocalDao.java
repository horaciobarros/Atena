package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Local;

public interface LocalDao  {

	List<Local> list();

	Local read(long id);

	void create(Local local);

	Local update(Local local);

	void delete(Local local);

	void delete(long id);

	public List<Local> pesquisa(Local local);

}