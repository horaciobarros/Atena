package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Frequencia;

public interface FrequenciaDao  {

	List<Frequencia> list();

	Frequencia read(long id);

	void create(Frequencia frequencia);

	Frequencia update(Frequencia frequencia);

	void delete(Frequencia frequencia);

	void delete(long id);

	public List<Frequencia> pesquisa(Frequencia frequencia);

}