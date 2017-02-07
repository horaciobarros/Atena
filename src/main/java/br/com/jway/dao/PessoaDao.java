package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.Pessoa;

public interface PessoaDao  {

	List<Pessoa> list();

	Pessoa read(long id);

	void create(Pessoa pessoa);

	Pessoa update(Pessoa pessoa);

	void delete(Pessoa pessoa);

	void delete(long id);

	public List<Pessoa> pesquisa(Pessoa pessoa);

}