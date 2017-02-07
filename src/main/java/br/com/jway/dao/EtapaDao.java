package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Etapa;

public interface EtapaDao  {

	List<Etapa> list();

	Etapa read(long id);

	void create(Etapa etapa);

	Etapa update(Etapa etapa);

	void delete(Etapa etapa);

	void delete(long id);

	public List<Etapa> pesquisa(Etapa etapa);

}