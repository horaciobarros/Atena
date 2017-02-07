package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Responsavel;

public interface ResponsavelDao  {

	List<Responsavel> list();

	Responsavel read(long id);

	void create(Responsavel responsavel);

	Responsavel update(Responsavel responsavel);

	void delete(Responsavel responsavel);

	void delete(long id);

	public List<Responsavel> pesquisa(Responsavel responsavel);

}