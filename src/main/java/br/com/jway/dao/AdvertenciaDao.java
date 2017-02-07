package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Advertencia;

public interface AdvertenciaDao  {

	List<Advertencia> list();

	Advertencia read(long id);

	void create(Advertencia advertencia);

	Advertencia update(Advertencia advertencia);

	void delete(Advertencia advertencia);

	void delete(long id);

	public List<Advertencia> pesquisa(Advertencia advertencia);

}