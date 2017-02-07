package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Aviso;

public interface AvisoDao  {

	List<Aviso> list();

	Aviso read(long id);

	void create(Aviso aviso);

	Aviso update(Aviso aviso);

	void delete(Aviso aviso);

	void delete(long id);

	public List<Aviso> pesquisa(Aviso aviso);

}