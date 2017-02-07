package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Turno;

public interface TurnoDao  {

	List<Turno> list();

	Turno read(long id);

	void create(Turno turno);

	Turno update(Turno turno);

	void delete(Turno turno);

	void delete(long id);

	public List<Turno> pesquisa(Turno turno);

}