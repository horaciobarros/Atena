package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Escola;

public interface EscolaDao  {

	List<Escola> list();

	Escola read(long id);

	void create(Escola escola);

	Escola update(Escola escola);

	void delete(Escola escola);

	void delete(long id);

	public List<Escola> pesquisa(Escola escola);

}