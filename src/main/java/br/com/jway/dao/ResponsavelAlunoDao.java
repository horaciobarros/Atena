package br.com.jway.dao; 

import java.io.*;
import java.util.*;
import br.com.jway.model.ResponsavelAluno;

public interface ResponsavelAlunoDao  {

	List<ResponsavelAluno> list();

	ResponsavelAluno read(long id);

	void create(ResponsavelAluno responsavelaluno);

	ResponsavelAluno update(ResponsavelAluno responsavelaluno);

	void delete(ResponsavelAluno responsavelaluno);

	void delete(long id);

	public List<ResponsavelAluno> pesquisa(ResponsavelAluno responsavelaluno);

}